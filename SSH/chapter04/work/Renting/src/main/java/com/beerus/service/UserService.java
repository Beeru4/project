package com.beerus.service;

import com.beerus.entity.Users;

import java.io.Serializable;

/**
 * 用户业务层
 */
public interface UserService {
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
