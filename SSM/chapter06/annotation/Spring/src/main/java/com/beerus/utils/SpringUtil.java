package com.beerus.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Beerus
 * @Description spring帮助类
 * @Date 2019/4/24
 **/
public class SpringUtil {
    //spring上下文对象
    private static ApplicationContext applicationContext;

    static {
        //加载spring配置资源
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    /**
     * 返回Spring上下文对象
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取Bean
     *
     * @param id
     * @return
     */
    public static Object getBean(String id) {
        return applicationContext.getBean(id);
    }
}
