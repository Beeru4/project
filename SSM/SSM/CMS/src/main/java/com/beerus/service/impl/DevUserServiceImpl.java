package com.beerus.service.impl;

import com.beerus.mapper.DevUserMapper;
import com.beerus.pojo.DevUser;
import com.beerus.service.DevUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Beerus
 * @Description 开发者业务层实现
 * @Date 2019-05-15
 **/
@Service("devUserService")
public class DevUserServiceImpl implements DevUserService {

    /**
     * 开发者映射接口
     */
    @Resource(name = "devUserMapper")
    private DevUserMapper devUserMapper;

    public DevUser login(String devCode, String devPassword) throws Exception {
        return devUserMapper.getDevUser(devCode, devPassword);
    }
}
