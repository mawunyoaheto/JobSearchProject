package edu.miu.cs.cs544.raymond.jobsearch.jms;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Job;
import edu.miu.cs.cs544.raymond.jobsearch.repository.JobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class Receiver {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    JobRepository jobRepository;

    @Autowired
    JmsTemplate jmsTemplate;
    private final SimpleMessageConverter converter = new SimpleMessageConverter();

    @JmsListener(destination = "job")
    public void receive(final Message message) throws JMSException {
        System.out.println("Received: " + this.converter.fromMessage(message));
        Job job = jobRepository.save((Job) this.converter.fromMessage(message));
        jmsTemplate.send(message.getJMSReplyTo(), new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                Message responseMsg = session.createObjectMessage(job);
                responseMsg.setJMSCorrelationID(message.getJMSCorrelationID());
                return responseMsg;
            }
        });
    }
}