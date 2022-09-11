package com.waa.springdata.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ActivityLogAspect {

    // Define cross-cuts or interception points
    @Pointcut("@annotation(com.waa.springdata.aop.annotation.LogThis)")
    public void logActivityPointCut() {
        System.out.println("We got you");
    }

    @Before(value = "logActivityPointCut()")
    public void validateIncomingRequests(JoinPoint joinPoint){
        System.out.println("Before PC: Method Name: " + joinPoint.getSignature().getName());
    }
    @After("logActivityPointCut()")
    public void waterOutGoingResponses(JoinPoint joinPoint){
        System.out.println("After PC: Method Name: " + joinPoint.getSignature().getName());
    }

}
