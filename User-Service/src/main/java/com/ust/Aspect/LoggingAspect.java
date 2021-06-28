package com.ust.Aspect;

import java.util.Date;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(com.stackroute.keepnote.controller.*)")
	public void logBefore() {
		logger.debug("@Before: {}", new Date());
	}

	@After("execution(com.stackroute.keepnote.controller.*)")
	public void logAfter() {
		logger.debug("@After: {}", new Date());
	}

	@AfterThrowing(pointcut = "execution(com.stackroute.keepnote.controller.*)", throwing = "exception")
	public void logAfterThrowing(Exception exception) {
		logger.debug("@AfterReturning: {}", new Date());
		logger.debug("Exception caught: {}", exception.getMessage());
	}

	@AfterReturning(pointcut = "execution(com.stackroute.keepnote.controller.*)", returning = "val")
	public void logAfterReturning(Object val) {
		logger.debug("Method return value: {}", val);
		logger.debug("@AfterReturning: {}", new Date());
	}
}
