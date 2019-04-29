package com.beerus.dao.impl;

import com.beerus.dao.UserDao;
import com.beerus.entiy.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/23
 **/
/*使用注解定义Dao @Component("userDao") 这种标示为在XML文件当中定义了一个Bean*/
/*标示为该类为Dao层并取名为userDao*/
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public int add(User user) throws Exception {
        /*   throw new  Exception("测试异常!");*/
        if (null != user) {
            System.out.println("add ok!");
            return 1;
        }
        throw new Exception("add error!");
    }
}
