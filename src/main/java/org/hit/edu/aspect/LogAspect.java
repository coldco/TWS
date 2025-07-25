package org.hit.edu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hit.edu.annotation.LogExecution;
import org.hit.edu.controller.LogController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogController.class);

    /**
     * 日志记录aop
     * @param joinPoint
     * @param logExecution
     * @return
     * @throws Throwable
     */
    @Around("@annotation(logExecution)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, LogExecution logExecution) throws Throwable {
        String serviceName = logExecution.value();
        long startTime = System.currentTimeMillis();
        log.info("{}开始执行",serviceName);
        
        Object result = joinPoint.proceed();
        
        long endTime = System.currentTimeMillis();
        log.info("{}执行结束",serviceName);
        log.info("运行耗时" + (endTime - startTime) + "ms");
        return result;
    }
}