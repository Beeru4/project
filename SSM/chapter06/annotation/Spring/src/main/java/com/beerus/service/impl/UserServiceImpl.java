package com.beerus.service.impl;

import com.beerus.dao.UserDao;
import com.beerus.entiy.User;
import com.beerus.exception.ErrorEnum;
import com.beerus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/23
 **/
/*标示该类为Service层*/
@Service("userService")
public class UserServiceImpl implements UserService {
    //使用IOC实现初始化

    /* @Autowired
     @Qualifier("userDao")*/
    private UserDao userDao;

    @Autowired
    //提供setter方法
    public void setUserDao(@Qualifier("userDao") UserDao userDao) {
        this.userDao = userDao;
    }

    public int register(User user) throws Exception {
        return userDao.add(user);
    }
}
