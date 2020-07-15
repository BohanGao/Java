package com.bohangao.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class UserProxy {

    @Pointcut(value = "execution(*  com.bohangao.annotation.User.add(..))")
    public void pointCut(){

    }

    @Before(value = "pointCut()")
    public void before(){
        System.out.println("UserProxy before...");
    }

    @After(value = "pointCut()")
    public void after(){
        System.out.println("UserProxy after...");
    }

    @AfterReturning(value = "pointCut()")
    public void afterReturning(){
        System.out.println("UserProxy afterReturning...");
    }

    @AfterThrowing(value = "pointCut()")
    public void afterThrowing(){
        System.out.println("UserProxy afterThrowing...");
    }

    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("UserProxy around before...");
        proceedingJoinPoint.proceed();
        System.out.println("UserProxy around after...");
    }

}
