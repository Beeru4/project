package com.beerus.service.impl;

import com.beerus.common.Mark;
import com.beerus.entity.Role;
import com.beerus.mapper.RoleMapper;
import com.beerus.mapper.impl.RoleMapperImpl;
import com.beerus.service.RoleService;

import java.util.List;

/**
 * @Author Beerus
 * @Description 角色业务层实现类
 * @Date 2019/4/20
 **/
public class RoleServiceImpl implements RoleService {
    private RoleMapper roleMapper = new RoleMapperImpl();

    public List<Role> list_Role() throws Exception {
        return roleMapper.list_Role();
    }
}
