package jp.co.axa.apidemo.aop;

import jp.co.axa.apidemo.utils.RestResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class EmployeeLogging {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeLogging.class);

    @AfterReturning(pointcut = "execution(* jp.co.axa.apidemo.controllers.EmployeeController.*(..))", returning = "result")
    public void postExecution(JoinPoint joinPoint, RestResponse result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        if (method.getName().equalsIgnoreCase("saveEmployee")) {
            LOG.info("Employee details saved successfully");
        } else if (method.getName().equalsIgnoreCase("deleteEmployee")) {
            LOG.info("Employee detail deleted successfully");
        } else if (method.getName().equalsIgnoreCase("updateEmployee")) {
            LOG.info("Employee detail updated successfully");
        }
    }
}
