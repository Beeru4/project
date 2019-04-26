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
        if (null != user) {
            return 1;
        }
        throw new Exception("add error!");
    }
}
