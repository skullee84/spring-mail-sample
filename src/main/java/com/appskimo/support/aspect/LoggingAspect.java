package com.appskimo.support.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created by dominic.lee on 2016. 10. 13..
 */
@Aspect
@Component
@EnableAspectJAutoProxy
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.appskimo.app..*.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String signatureInfo = getSignatureInfo(joinPoint);

        logger.debug("=>> " + signatureInfo);
        Object retVal = joinPoint.proceed();
        logger.debug("<<= " + signatureInfo + (retVal != null ? " : " + retVal : ""));

        return retVal;
    }

    @Pointcut
    private String getSignatureInfo(JoinPoint joinPoint) {
        String signatureName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        StringBuilder sb = new StringBuilder();

        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof String){
                    sb.append('\"');
                }

                sb.append(args[i]);

                if (args[i] instanceof String){
                    sb.append('\"');
                }

                if (i < args.length - 1) {
                    sb.append(',');
                }
            }
        }
        return String.format("%s.%s(%s)", className, signatureName, sb.toString());
    }
}
