package com.beerus.service;

import com.beerus.pojo.DevUser;

/**
 * @Author Beerus
 * @Description 开发者用户业务层
 * @Date 2019-05-15
 **/
public interface DevUserService {
    /**
     * 开发者用户登入
     *
     * @param devCode     编码
     * @param devPassword 密码
     * @return
     */
    DevUser login(String devCode, String devPassword) throws Exception;
}
