package edu.miu.cs.cs544.raymond.jobsearch.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectJDeleteLogging {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @After("execution(* edu.miu.cs.cs544.raymond.jobsearch.repository.*.deleteById(..))")
    public void save(JoinPoint joinPoint){
        logger.info(" Delete Operation:  "+joinPoint.getSignature().getDeclaringTypeName()+" "+joinPoint.getTarget());
    }
}
