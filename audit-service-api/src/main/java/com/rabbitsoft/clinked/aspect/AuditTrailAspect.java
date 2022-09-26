package com.rabbitsoft.clinked.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Log4j2
public class AuditTrailAspect {

    @Around("@annotation(com.rabbitsoft.clinked.aspect.AuditTrail)")
    public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {

        //method call parameters
        log.error("Input :{}", joinPoint.getArgs()[0]);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        log.error("Request: {}", request.getRemoteAddr());

        //security context
        //todo SecurityContext.getContext();

        //result of the method
        Object result = joinPoint.proceed();

        log.error("Resut: {}", request);

        return result;
    }

}
