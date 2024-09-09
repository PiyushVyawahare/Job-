package com.vyawpiy.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.vyawpiy.spring_boot_rest.service.JobService.getJobPost(..)) || execution(* com.vyawpiy.spring_boot_rest.service.JobService.deleteJob(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method Called " + jp.getSignature().getName());
    }

    @After("execution(* com.vyawpiy.spring_boot_rest.service.JobService.getJobPost(..)) || execution(* com.vyawpiy.spring_boot_rest.service.JobService.deleteJob(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method Executed " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.vyawpiy.spring_boot_rest.service.JobService.getJobPost(..)) || execution(* com.vyawpiy.spring_boot_rest.service.JobService.deleteJob(..))")
    public void logMethodThrowsException(JoinPoint jp) {
        LOGGER.info("Method throws exception " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.vyawpiy.spring_boot_rest.service.JobService.getJobPost(..)) || execution(* com.vyawpiy.spring_boot_rest.service.JobService.deleteJob(..))")
    public void logMethodReturned(JoinPoint jp) {
        LOGGER.info("Method returned successfully " + jp.getSignature().getName());
    }
}
