package com.demo1.demo.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Pointcut(value="execution(* com.demo1.demo.*.*.*(..))")

    public void loggingPointCut(){

    }
    @Around("loggingPointCut()")
    public Object loggingAdvice(ProceedingJoinPoint pj) throws Throwable{
        ObjectMapper mapper = new ObjectMapper();
        String methodName=pj.getSignature().getName();
        String className= pj.getTarget().getClass().toString();


        Object [] array = pj.getArgs();
        log.info("Inside "+className+"class"+methodName+" method,with request: " +mapper.writeValueAsString(array));

        Object response= pj.proceed();
        log.info("Inside "+className+"class"+methodName+" method,with request: " +mapper.writeValueAsString(response));
        return response;
    }
}
