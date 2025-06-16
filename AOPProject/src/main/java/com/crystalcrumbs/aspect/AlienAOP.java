package com.crystalcrumbs.aspect;

import java.time.LocalDateTime;

//import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AlienAOP {
	
	// void,int, 
	//* com.crystalcrumbs.rest.*.*(..) 
	//i want to run with any return type (*)
	//in package com.crystalcrumbs.rest
	//in any class *
	//in any method *
	//wih any parameter (..)
	
	@Before(value="execution(* com.crystalcrumbs.rest.AlienController.*(..))")
	public void beforeAdvice(JoinPoint joinpoint) {
		System.out.println("Request Made to "+joinpoint.getSignature()+" at about "+LocalDateTime.now());
		
	}
	
	@After(value="execution(* com.crystalcrumbs.rest.AlienController.*(..))")
	public void afterAdvice(JoinPoint joinpoint) {
		System.out.println("Request Made to "+joinpoint.getSignature()+" at about "+LocalDateTime.now());
		
	}
	
	@Before(value="execution(* com.crystalcrumbs.service.AlienService.*(..))")
	public void beforeAdviceService(JoinPoint joinpoint) {
		System.out.println("Service Request Made to "+joinpoint.getSignature()+" at about "+LocalDateTime.now());
		
	}
	
	@After(value="execution(* com.crystalcrumbs.service.AlienService.*(..))")
	public void afterAdviceService(JoinPoint joinpoint) {
		System.out.println("Service Request Made to "+joinpoint.getSignature()+" at about "+LocalDateTime.now());
		
	}

}
