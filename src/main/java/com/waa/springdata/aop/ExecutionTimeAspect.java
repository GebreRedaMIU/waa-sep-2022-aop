package com.waa.springdata.aop;

import com.waa.springdata.entity.ActivityLog;
import com.waa.springdata.service.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Autowired
    private ActivityLogService activityLogService;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Pointcut("@annotation(com.waa.springdata.aop.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ActivityLog activityLog = new ActivityLog();
        this.httpServletRequest.getHeaderNames().asIterator().forEachRemaining(h ->
                System.out.println("Header: "+ h)
        );
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName() + " took ns: " + (finish - start));
        activityLog.setDate(LocalDateTime.now());
        activityLog.setDuration((int) (finish - start));
        activityLog.setOperation(proceedingJoinPoint.getSignature().getName());
        this.activityLogService.save(activityLog);
        return result;
    }

}
