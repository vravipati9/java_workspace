package org.rsr.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	//@Before("execution(public String org.rsr.aop.CircleModel.getName())")
	//@Before("execution(public String org.rsr.aop.CircleModel.getName())")
	//@Before("execution(public * get*())")
	//@Before("allGetters()")
	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint) {
		System.out.println("Advice run. Get method called.."+joinPoint.toString());
	}
	
	// This method executes for all getters. This is called Pointcut
	@Pointcut("execution(* get*())")
	public void allGetters() {}
	
	@Pointcut("within(org.rsr.aop.CircleModel)")
	public void allCircleMethods() {}
	
	@Before("args(name)")
	public void stringArgumentMethods(String name) {
		System.out.println("A method that takes string argument has been called>.."+name);
	}
	
}
