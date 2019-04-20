package com.beerus.service;

import com.beerus.entity.Users;

import java.util.List;

/**
 * 用户业务层
 */
public interface UserService {
    /**
     * 添加用户
     *
     * @param user
     */
    int register(Users user);

    /**
     * 登录
     *
     * @param user 用户
     * @return 返回用户
     */
    Users login(Users user);

    /**
     * 查找所有用户
     *
     * @return 用户集合
     */
    List<Users> findAllUser();

    /**
     * 检查用户名是否存在
     * @param name 用户名
     * @return
     */
    boolean checkUserName(String name);
}
