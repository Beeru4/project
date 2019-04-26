package com.beerus.dao.impl;

import com.beerus.dao.UserDao;
import com.beerus.entiy.User;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/23
 **/
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
