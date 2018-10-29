package com.java.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LoggingService {

	Logger logger = LoggerFactory.getLogger(LoggingService.class);
	/*
	 * AsyncAppender acts as a dispatcher to another appender. It buffers
	 * ILoggingEvents and dispatches them to another appender asynchronously. This
	 * improves the application’s performance because it allows the application to
	 * not have to wait for the logging subsystem to complete the action. There is a
	 * potential heap memory leak when the buffer builds quicker that it can be
	 * drained. Luckily, Logback provides configuration options to address that.
	 */

	@Around(value = "within( com.java.controller.*)")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(Thread.currentThread().getName());
		logger.info("Entering method " + pjp.getSignature());
		Object o = pjp.proceed();
		logger.info("Exiting method" + pjp.getSignature());
		return o;
	}

	/*
	 * @AfterReturning(returning="returnValue",
	 * pointcut="within(com.java.controller.CacheDemoController)") public Object
	 * logCacheController(Object returnValue, JoinPoint joinpoint,
	 * HttpServletResponse response) {
	 * logger.debug("Header value for cache-control:"+
	 * response.getHeader("Cache-Control")); return returnValue; }
	 */

}
