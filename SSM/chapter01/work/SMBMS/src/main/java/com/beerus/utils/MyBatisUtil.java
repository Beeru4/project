package com.beerus.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Beerus
 * @Description MyBatis工具类
 * @Date 2019/4/18
 **/
public class MyBatisUtil {
    //得到mybatis核心类
    private static SqlSessionFactory sessionFactory;
    //会话对象
    private static SqlSession session;

    static {
        try {
            //获取文件的输入流 加载mybatis的配置信息
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //读取配置文件
            sessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 打开会话
     *
     * @return 会话
     */
    public static SqlSession openSession() throws Exception {
        return session = sessionFactory.openSession();
    }

    /**
     * 关闭会话
     *
     * @param sqlSession 要关闭的会话
     * @throws Exception
     */
    public static void closeSession(SqlSession sqlSession) throws Exception {
        if (null != sqlSession) {
            sqlSession.close();
        }
    }
}
