package com.beerus.dao;

import com.beerus.entiy.User;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/23
 **/
public interface UserDao {
    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int add(User user) throws Exception;
}
