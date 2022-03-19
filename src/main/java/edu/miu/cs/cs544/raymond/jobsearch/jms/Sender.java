package edu.miu.cs.cs544.raymond.jobsearch.jms;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

@Component
public class Sender {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value(value = "${springjms.mqName}")
    private String queueName;
    private final SimpleMessageConverter converter = new SimpleMessageConverter();
    public Job send(Job job) throws JMSException {
        jmsTemplate.setReceiveTimeout(20000);
        Message received = jmsTemplate.sendAndReceive("job", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                String msgId = "foo";
                ObjectMessage message = session.createObjectMessage(job);
                message.setJMSCorrelationID(msgId);
                System.out.println("JMS Sender - Job sent to receiver: "+ job);
                return message;
            }});
        return  (Job) this.converter.fromMessage(received);
    }
}