package edu.miu.cs.cs544.raymond.jobsearch.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CrudAspectJLogging {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Autowired
//    private Sender sender;

    @Before("execution(* edu.miu.cs.cs544.raymond.jobsearch.repository.*.*(..))")
    public void save(JoinPoint joinPoint){

//        sender.send("JMS LOG: Saving Crud Operation"+joinPoint.getSignature().getDeclaringTypeName()+" "+joinPoint.getTarget());
        logger.info(" Saving a Crud Operation  "+joinPoint.getSignature().getDeclaringTypeName()+" "+joinPoint.getTarget());
    }
}
