package com.beerus.aop;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

/**
 * @Author Beerus
 * @Description 织入方法类
 * @Date 2019/4/23
 **/
public class ServiceLogger {
    private Logger logger = Logger.getLogger(ServiceLogger.class);

    /**
     * 方法执行前
     *
     * @param jp
     */
    public void before(JoinPoint jp) {
        logger.debug("execute:"
                + jp.getTarget()
                + "\tfunction Name:" + jp.getSignature().getName()
                + "\tparams:" + Arrays.toString(jp.getArgs()));
    }

    /**
     * 方法执行之后
     *
     * @param jp
     */
    public void afterReturning(JoinPoint jp, Object result) {
        logger.debug("execute:"
                + jp.getTarget()
                + "\tfunctionName:" + jp.getSignature().getName()
                + "\tparams:" + Arrays.toString(jp.getArgs())
                + "\treturnResult:" + result);

    }
}
