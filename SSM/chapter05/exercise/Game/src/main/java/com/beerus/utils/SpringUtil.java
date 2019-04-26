package com.beerus.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Beerus
 * @Description Spring工具类
 * @Date 2019/4/23
 **/
public class SpringUtil {
    private static ApplicationContext applicationContext;

    static {
        //初始化applicationContext 加载配置文件
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    /**
     * 得到Bean
     * @param id
     * @return
     */
    public static Object getBean(String id) {
        return applicationContext.getBean(id);
    }
}
