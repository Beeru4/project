package com.beerus.service.impl;

import com.beerus.common.Mark;
import com.beerus.entity.Role;
import com.beerus.mapper.RoleMapper;
import com.beerus.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Beerus
 * @Description 角色业务层实现类
 * @Date 2019/4/20
 **/
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    /**
     * 角色数据层
     */
    @Resource(name = "roleMapper")
    private RoleMapper roleMapper;

    @Transactional(readOnly = true)
    public List<Role> list_Role() throws Exception {
        return roleMapper.list_Role();
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean delete_Role(Integer roleId) {
        //判断该角色是否被引用
        if (roleMapper.count_roleByDel(roleId) == Mark.ERROR) {
            //判断是否删除成功
            if (roleMapper.delete_Role(roleId) > Mark.DELETE_ERROR) {
                //删除成功
                return true;
            }
        }
        ///删除失败
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean modify_Role(Role role) {
        return roleMapper.update_Role(role) > Mark.UPDATE_ERROR;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean add_Role(Role role) {
        return roleMapper.save_Role(role) > Mark.SAVE_ERROR;
    }

    @Transactional(readOnly = true)
    public boolean checkRoleCode(String roleCode) {
        return roleMapper.count_role(roleCode) > Mark.ERROR;
    }

    @Transactional(readOnly = true)
    public Role serachRole(Integer roleId) {
        return roleMapper.get_Role(roleId);
    }


}
