package com.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {

    private int view = 0;

    @Before(value = "execution(* com.codegym.controller.BookController.*(..))")
    public void logViewBook(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        view += 1;

        System.err.println("bạn đã ghé " + methodName);
        System.err.println("lượt view " + view);
    }

    @AfterReturning(value = "execution(* com.codegym.controller.BookController.rentBook(..))")
    public void logChangeBookRent (JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.err.println("method " + methodName + " đã chạy xong");
        System.err.println("trạng thái sách đã được thay đổi");
    }

    @AfterReturning(value = "execution(* com.codegym.controller.BookController.returnBook(..))")
    public void logChangeBookReturn(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.err.println("method " + methodName + " đã chạy xong");
        System.err.println("trạng thái sách đã được thay đổi");
    }
}
