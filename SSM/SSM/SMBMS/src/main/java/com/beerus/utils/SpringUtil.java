package com.beerus.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Beerus
 * @Description spring工具类
 * @Date 2019-04-29
 **/
public class SpringUtil {
    //spring全局对象
    private static ApplicationContext applicationContext;

    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
    }

    /**
     * 得到Bean
     *
     * @param beanID
     * @return
     */
    public static Object getBean(String beanID) throws Exception {
        return applicationContext.getBean(beanID);
    }
}
