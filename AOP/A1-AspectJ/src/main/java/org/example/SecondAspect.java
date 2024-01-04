package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class SecondAspect {
    @Pointcut("execution(* org.example.test.App.main(..))")
    public void pc1() {
    }

    @After("pc1()")
    public void afterMain() {
        System.out.println("**********************************");
        System.out.println("After main method from SecondAspect");
        System.out.println("**********************************");
    }

    @Before("pc1()")
    public void beforeMain() {
        System.out.println("**********************************");
        System.out.println("Before main method from SecondAspect");
        System.out.println("**********************************");
    }


    @Around("pc1()")
    public void aroundMain(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("**********************************");
        System.out.println("Before main method from SecondAspect");
        System.out.println("**********************************");
        proceedingJoinPoint.proceed();
        System.out.println("**********************************");
        System.out.println("After main from method SecondAspect");
        System.out.println("**********************************");
    }


}
