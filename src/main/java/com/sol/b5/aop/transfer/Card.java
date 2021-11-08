package com.sol.b5.aop.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {
	
	//@Before("execution(* com.sol.b5.aop.transfer.Transfer.*(..))")
	//@AfterReturning("execution(* com.sol.b5.aop.transfer.Transfer.*(..))")
	@Around("execution(* com.sol.b5.aop.transfer.Transfer.*(..))")
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("--- 타기 전 Card check ---");
		Object obj = joinPoint.proceed(); //핵심 로직 실행
		System.out.println("--- 내린 후 Card check ---");
		
		return obj;
	}
}
