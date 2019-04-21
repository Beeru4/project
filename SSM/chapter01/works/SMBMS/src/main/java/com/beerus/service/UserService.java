package com.beerus.service;

import com.beerus.entity.SmbmsUser;

/**
 * @Author Beerus
 * @Description 用户业务层
 * @Date 2019/4/20
 **/
public interface UserService {
    /**
     * 用户登录
     *
     * @param code 用户编码
     * @param pwd  密码
     * @return
     */
    SmbmsUser login(String code, String pwd) throws Exception;
}
