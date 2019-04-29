package com.beerus.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Beerus
 * @Description Spring工具类
 * @Date 2019-04-28
 **/
public class SpringUtil {
    //Spring上下文对象
    private static ApplicationContext applicationContext;

    static {
        //加载Spring配置
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    /**
     * @return 返回Spring全局对象
     * @throws Exception
     */
    public static ApplicationContext getApplicationContext() throws Exception {
        return applicationContext;
    }

    /**
     * @param beanID BeanID
     * @return 返回Bean
     * @throws Exception
     */
    public static Object getBean(String beanID) throws Exception {
        return applicationContext.getBean(beanID);
    }
}
