package com.beerus.service.impl;

import com.beerus.entity.SmbmsUser;
import com.beerus.mapper.UserMapper;
import com.beerus.mapper.impl.UserMapperImpl;
import com.beerus.service.UserService;

/**
 * @Author Beerus
 * @Description 用户业务层实现类
 * @Date 2019/4/20
 **/
public class UserServiceImpl implements UserService {
    private UserMapper userMapper = new UserMapperImpl();

    @Override
    public SmbmsUser login(String code, String pwd) throws Exception {
        return userMapper.get_findByNameAndPwd(code, pwd);
    }
}
