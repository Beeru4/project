package com.beerus.service;

import com.beerus.entiy.User;

public interface UserService {
    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int register(User user) throws Exception;
}
