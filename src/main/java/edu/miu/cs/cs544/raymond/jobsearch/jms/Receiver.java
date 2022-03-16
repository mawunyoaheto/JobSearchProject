package edu.miu.cs.cs544.raymond.jobsearch.jms;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Job;
import edu.miu.cs.cs544.raymond.jobsearch.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    JobService jobService;

    @JmsListener(destination = "${springjms.mqName}")
    public void receive(Job job) {

        logger.info("JMS received: "+job);
       jobService.addJob(job);
    }
}