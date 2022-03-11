package edu.miu.cs.cs544.raymond.jobsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class JobSearchApplication {

    public static void main(String[] args) {
        System.out.println("App start...");
        SpringApplication.run(JobSearchApplication.class, args);
        System.out.println("App end...");
    }

}
