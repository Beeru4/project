package com.beerus.service.impl;

import com.beerus.mapper.BackendUserMapper;
import com.beerus.pojo.BackendUser;
import com.beerus.service.BackendUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Beerus
 * @Description 后台用户业务层实现
 * @Date 2019-05-15
 **/
@Service(value = "backendUserService")
public class BackendUserServiceImpl implements BackendUserService {

    /**
     * 后台映射接口
     */
    @Resource(name = "backendUserMapper")
    private BackendUserMapper backendUserMapper;

    public BackendUser login(String userCode, String userPassword) throws Exception {
        return backendUserMapper.getBackendUser(userCode, userPassword);
    }
}
