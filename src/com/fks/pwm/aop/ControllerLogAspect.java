package com.fks.pwm.aop;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLogAspect {

	private static Logger logger = Logger.getLogger(ControllerLogAspect.class);
	
	@Before("execution(* com.fks.pwm.controller..*.*(..))")
	public void logBefore(JoinPoint joinPoint){
		logger.info(" # CLASS : " + joinPoint.getTarget().getClass()+ " # Method : " + joinPoint.getSignature().getName()+ "() # Arguments : " + Arrays.toString(joinPoint.getArgs()));
	}
	
}
