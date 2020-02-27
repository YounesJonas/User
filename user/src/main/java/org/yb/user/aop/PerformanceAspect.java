package org.yb.user.aop;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceAspect {

	private static final Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

	@Around("execution(* org.yb.user.rest.*.*(..))")
	public Object processTime(ProceedingJoinPoint jp) throws Throwable {
		Instant start = Instant.now();
		Object response = jp.proceed();
		Instant finish = Instant.now();
		logger.info("Rest call to {} takes {} ms", jp.getSignature().getName(),
				Duration.between(start, finish).toMillis());
		return response;
	}

}
