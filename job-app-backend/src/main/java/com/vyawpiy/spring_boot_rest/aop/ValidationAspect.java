package com.vyawpiy.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.vyawpiy.spring_boot_rest.service.JobService.getJobPost(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint pjp, int postId) throws Throwable {

        if(postId < 0) {
            LOGGER.info("Updating negative postId: " + postId);
            postId = -postId;
            LOGGER.info("Updated postId: " + postId);
        }

        Object obj = pjp.proceed(new Object[]{postId});

        return obj;
    }

}
