package com.beerus.service.impl;

import com.beerus.entity.Role;
import com.beerus.mapper.RoleMapper;
import com.beerus.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Beerus
 * @Description 角色业务层实现类
 * @Date 2019/4/20
 **/
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    //角色数据层
    @Resource(name = "roleMapper")
    private RoleMapper roleMapper;

    public List<Role> list_Role() throws Exception {
        return roleMapper.list_Role();
    }
}
