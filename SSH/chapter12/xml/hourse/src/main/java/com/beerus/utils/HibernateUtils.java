package com.beerus.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate工具类
 */
public class HibernateUtils {
    //会话工厂对象
    private final static SessionFactory sessionFactory;

    //静态代码块初始化工具类
    static {
        //加载配置文件信息
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        //返回会话工厂
        sessionFactory = configuration.buildSessionFactory();
    }

    /**
     * getCurrentSession创建会话对象
     * @return
     */
    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * openSession创建会话对象
     * @return
     */
    public static  Session openSession(){
        return sessionFactory.openSession();
    }
}
