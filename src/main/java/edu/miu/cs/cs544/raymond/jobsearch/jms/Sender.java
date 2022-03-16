package edu.miu.cs.cs544.raymond.jobsearch.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value(value = "${springjms.mqName}")
    private String queueName;

    public void send(Object job) {
        logger.info("JMS sent: " + job);
        jmsTemplate.convertAndSend(queueName, job);
    }
}