package com.beerus.service.impl;

import com.beerus.dao.UserDao;
import com.beerus.entiy.User;
import com.beerus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/23
 **/
/*标示该类为Service层*/
@Service("userService2")
public class UserServiceImpl2 implements UserService {
    //使用IOC实现初始化

    /* @Autowired
     @Qualifier("userDao")*/
    @Resource(name = "userDao")
    private UserDao userDao;

/*    @Autowired
    //提供setter方法
    public void setUserDao(@Qualifier("userDao") UserDao userDao) {
        this.userDao = userDao;
    }*/

    public int register(User user) throws Exception {
        return userDao.add(user);
    }
}
