package com.beerus.utils;

import com.beerus.exception.BeanIdNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Beerus
 * @Description spring工具类
 * @Date 2019/4/23
 **/
public class SpringUtil {
    //Spring上下文对象
    private static ApplicationContext applicationContext;

    static {
        //读取Spring配置文件得到上下文对象
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    /**
     * 得到Spring上下文对象
     *
     * @return
     * @throws Exception
     */
    public static ApplicationContext getApplicationContext() throws Exception {
        return applicationContext;
    }

    /**
     * 得到Bean对象
     *
     * @param id BeanID
     * @return
     * @throws Exception
     */
    public static Object getBean(String id) throws Exception {
        if (null == id || "".equals(id.trim())) {
            throw new BeanIdNotFoundException("Bean id is Empty Or Null!");
        }
        return applicationContext.getBean(id);
    }
}
