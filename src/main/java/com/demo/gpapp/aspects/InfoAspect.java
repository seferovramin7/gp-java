package com.demo.gpapp.aspects;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class InfoAspect {

    String uuid;

    @Pointcut("execution(* com.demo.gpapp.controller.InfoController.*(..))")
    public void controllerPointcut() {
    }


    @Before("controllerPointcut()")
    public void logMethod(JoinPoint joinPoint) {
        uuid = UUID.randomUUID().toString().replace("-", "");
        log.info("==> {} Request body: {}", uuid, joinPoint.getArgs());
    }

    @AfterReturning(pointcut =
            "execution(* com.demo.gpapp.controller.InfoController.saveText(..)))",
            returning = "retVal")
    public void logAfterReturningControllerResponse(Object retVal) {
        log.info("==> {} Info Response body: {}", uuid, retVal);
    }

}
