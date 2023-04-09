package com.aop.aop.order.Aspect1;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.util.IStructureModel;

@Slf4j
@Aspect
public class Aspect1 {
    @Around("execution(* com.aop.aop.order..*(..))")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("log->{}", joinPoint.getSignature());
        return joinPoint.proceed();
    }
}
