package com.beerus.dao;

import com.beerus.entity.Users;

import java.io.Serializable;

/**
 * 用户数据层
 */
public interface UserDao {
    /**
     * 添加用户
     * @param user
     */
    void addUser(Users user);

    /**
     * 修改用户
     * @param user
     */
    void update(Users user);

    /**
     * 删除用户
     * @param user
     */
    void delete(Users user);

    /**
     * 查询用户
     * @param clzz
     * @param id
     * @return
     */
    Users query(Class clzz, Serializable id);
}


