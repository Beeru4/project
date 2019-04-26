package com.beerus.aop;

import com.beerus.entity.Equip;
import org.aspectj.lang.JoinPoint;

/**
 * @Author Beerus
 * @Description 增强类
 * @Date 2019/4/23
 **/
public class Pointcut {
    public void before(JoinPoint jp) throws Exception {
        //得到参数 判断是否是指环
        Equip equip = (Equip) jp.getArgs()[0];
        //不是指环 中断操作
        if (!"指环".equals(equip.getType())) {
            throw new Exception("type is no Ring!");
        }
    }
}
