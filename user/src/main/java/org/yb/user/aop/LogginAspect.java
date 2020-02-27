package org.yb.user.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
@Aspect
@Configuration
public class LogginAspect {

	private static final Logger logger = LoggerFactory.getLogger(LogginAspect.class);

	@Before("execution(* org.yb.user.rest.*.*(..))")
	public void beginRestCall(JoinPoint jp) {
		logger.info("Begin Rest call to {} with input {}", jp.getSignature().getName(), jp.getArgs()[0]);
	}

	@AfterReturning(pointcut = "execution(* org.yb.user.rest.*.*(..))", returning = "response")
	public void endRestCall(JoinPoint jp, Object response) {
		logger.info("End Rest call to {} with output {}", jp.getSignature().getName(), response);
	}
}
