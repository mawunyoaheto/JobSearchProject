package edu.miu.cs.cs544.raymond.jobsearch;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
@OpenAPIDefinition(info = @Info(title = "JobSearch API", version = "1.0", description = "Job Search Information"))
public class JobSearchApplication {

    public static void main(String[] args) {
        System.out.println("App start...");
        SpringApplication.run(JobSearchApplication.class, args);
        System.out.println("App end...");
    }

}
