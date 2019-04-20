package com.beerus.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @Author Beerus
 * @Description mybatis工具类
 * @Date 2019/4/19
 **/
public class MyBatisUtil {
    //创建会话工厂
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到会话
     *
     * @return
     */
    public static SqlSession openSession() throws Exception {
        return sqlSessionFactory.openSession();
    }

    /**
     * 关闭会话
     *
     * @param sqlSession
     * @return
     */
    public static boolean closeSession(SqlSession sqlSession) throws Exception {
        if (null != sqlSession) {
            sqlSession.close();
            return true;
        }
        return false;
    }
}
