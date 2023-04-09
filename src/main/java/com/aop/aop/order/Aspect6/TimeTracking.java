package com.aop.aop.order.Aspect6;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Slf4j
@Aspect
@Order(0)
public class TimeTracking {
    long start = System.currentTimeMillis();
    int id = 0;

    @Around("com.aop.aop.order.Aspect6.Pointcuts.allService()")
    public void timeTracked(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("Time Tracking start->{}",id++);
        try{
            joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            log.info("Time Spent ->{}", finish-start);
        }
    }
}
