package com.beerus.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * @Author Beerus
 * @Description 增强类
 * @Date 2019/4/24
 **/
public class ServiceLogger {
    private Logger logger = Logger.getLogger(ServiceLogger.class);

    /**
     * 环绕增强
     *
     * @param pjp
     */
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //方法执行前
        logger.debug("调用:" + pjp.getTarget()
                + "的" + pjp.getSignature().getName()
                + "方法.方法入参:" + Arrays.toString(pjp.getArgs()));

        //方法执行
        try {
            //返回执行结果
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.error(throwable.getMessage());
            throw throwable;
        } finally {
            //方法执行后
            logger.debug("方法执行完毕!");
        }
    }
}
