package org.example;

public aspect FirstAspect {

    pointcut pc1(): execution(* org.example.test.App.main(..));

    before(): pc1(){
        System.out.println("**********************************************");
        System.out.println("Before main from FirstAspect with AspectJ Syntax");
        System.out.println("**********************************************");
    }

    after(): pc1(){
        System.out.println("**********************************************");
        System.out.println("After main from Aspect with AspectJ syntax");
        System.out.println("**********************************************");
    }

    void around(): pc1(){
        System.out.println("**********************************************");
        System.out.println("Before main from FirstAspect with AspectJ Syntax");
        System.out.println("**********************************************");


        proceed();
        System.out.println("**********************************************");
        System.out.println("After main from Aspect with AspectJ syntax");
        System.out.println("**********************************************");
    }
}
