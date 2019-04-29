package com.beerus.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @Author Beerus
 * @Description 切面
 * @Date 2019/4/24
 **/
/*标注为增强类*/
@Aspect
public class ServiceLogger {
    private Logger logger = Logger.getLogger(ServiceLogger.class);

    @Pointcut("execution(* com.beerus.service.impl.UserServiceImpl.register(com.beerus.entiy.User))")
    //签名(代码重用,提取表达式)
    public void pointcut() {
    }

    /**
     * 前置增强
     *
     * @param jp
     */
    @Before("pointcut()")
    public void before(JoinPoint jp) {
        logger.debug("前置增强:调用:" + jp.getTarget()
                + "的" + jp.getSignature().getName()
                + "方法.方法入参:" + Arrays.toString(jp.getArgs()));
    }

    /**
     * 后置增强
     *
     * @param jp
     * @param result
     */
    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        logger.debug("后置增强:调用:" + jp.getTarget()
                + "的" + jp.getSignature().getName()
                + "方法.方法入参:" + Arrays.toString(jp.getArgs()) + "结果为:" + result);
    }
}
