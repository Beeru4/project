package com.beerus.service;


import com.beerus.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色业务层
 */
public interface RoleService {
    /**
     * 查询所有用户
     *
     * @return
     */
    List<Role> list_Role() throws Exception;
    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    boolean delete_Role(Integer roleId);

    /**
     * 修改角色
     *
     * @param role
     * @return
     */
    boolean modify_Role(Role role);

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    boolean add_Role(Role role);

    /**
     * 验证角色编码是否一致
     *
     * @param roleCode
     * @return
     */
    boolean checkRoleCode(String roleCode);

    /**
     * 根据ID查询角色
     *
     * @param roleId
     * @return
     */
    Role serachRole(Integer roleId);
}
