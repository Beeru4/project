package com.beerus.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Beerus
 * @Description mybatis工具类
 * @Date 2019/4/18
 **/
public class MyBatisUtil {
    //创建会话工厂
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到会话
     *
     * @return
     */
    public static SqlSession getSqlSession() throws Exception{
        return sqlSessionFactory.openSession();
    }

    /**
     * 关闭会话
     * @param sqlSession
     */
    public static void closeSqlSession(SqlSession sqlSession) throws Exception{
        if (null != sqlSession) {
            sqlSession.close();
        }
    }

}
