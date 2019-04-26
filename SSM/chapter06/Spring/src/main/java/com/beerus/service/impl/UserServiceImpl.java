package com.beerus.service.impl;

import com.beerus.dao.UserDao;
import com.beerus.entiy.User;
import com.beerus.exception.ErrorEnum;
import com.beerus.service.UserService;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/23
 **/
public class UserServiceImpl implements UserService {
    //使用IOC实现初始化
    private UserDao userDao;

    //提供setter方法
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public int register(User user) throws Exception {
        return userDao.add(user);
    }
}
