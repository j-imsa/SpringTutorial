package be.jimsa.springtutorial.ws.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
@Slf4j
public class AppLogAspect {

    // @Around("execution(* be.jimsa.springtutorial.ws.services.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Executing {}", joinPoint.getSignature().toString());
        Instant start = Instant.now();
        joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        log.info("Time elapsed: {}", timeElapsed);
        log.info("Executed {}", joinPoint.getSignature().getName());
    }

    @Around("@annotation(be.jimsa.springtutorial.ws.aspects.MethodLogAspect)")
    public void logWithAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        log(joinPoint);
    }
}
