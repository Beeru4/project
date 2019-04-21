package com.beerus.service.impl;

import com.beerus.common.Mark;
import com.beerus.entity.SmbmsRole;
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

    @Override
    public boolean save_Role(SmbmsRole smbmsRole) throws Exception {
        return roleMapper.save_Role(smbmsRole) > Mark.SAVE_ERROR;
    }

    @Override
    public boolean update_Role(SmbmsRole smbmsRole) throws Exception {
        return roleMapper.update_Role(smbmsRole) > Mark.UPDATE_ERROR;
    }

    @Override
    public boolean delete_Role(Integer roleId) throws Exception {
        //判断该角色下是否是有用户
        if (roleMapper.get_Role(roleId).getTotalCount() == Mark.ERROR) {
            //无用户 执行删除
            return roleMapper.delete_Role(roleId) > Mark.DELETE_ERROR;
        }
        return false;
    }

    @Override
    public List<SmbmsRole> list_findByName(String roleName) throws Exception {
        return roleMapper.list_findByName(roleName);
    }
}
