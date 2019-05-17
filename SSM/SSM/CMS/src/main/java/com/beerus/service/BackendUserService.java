package com.beerus.service;

import com.beerus.pojo.BackendUser;

/**
 * @Author Beerus
 * @Description 后台用户业务层
 * @Date 2019-05-15
 **/
public interface BackendUserService {
    /**
     * 后台用户登入
     *
     * @param userCode     编码
     * @param userPassword 密码
     * @return
     */
    BackendUser login(String userCode, String userPassword) throws Exception;
}
