package com.waa.springdata.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class CheckPostHeadersAspect {

HttpServletRequest request;

    public CheckPostHeadersAspect(HttpServletRequest request) {
        this.request = request;
    }

    @Pointcut("within(com.waa.springdata.service..*)")
    public void checkPostPointCut(){}

    @Before(value = "checkPostPointCut()")
    public void checkPostHeaderForValue(){
        if (this.request.getHeader("aop-is-awesome") == null &&
                this.request.getHeader("AOP-IS-AWESOME") == null ) {
            System.out.println("AOP-IS-AWESOME is missing");
            throw new RuntimeException("AopIsAwesomeHeaderException ");
        }

    }
}
