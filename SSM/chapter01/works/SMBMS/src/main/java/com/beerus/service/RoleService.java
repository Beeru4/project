package com.beerus.service;

import com.beerus.entity.SmbmsRole;

import java.util.List;

/**
 * 角色业务层
 */
public interface RoleService {
    /**
     * 添加角色信息
     *
     * @param smbmsRole 角色信息
     * @return
     */
    boolean save_Role(SmbmsRole smbmsRole) throws Exception;

    /**
     * 修改角色信息
     *
     * @param smbmsRole 角色信息
     * @return
     */
    boolean update_Role(SmbmsRole smbmsRole) throws Exception;

    /**
     * 删除角色
     *
     * @param roleId 角色ID
     * @return
     */
    boolean delete_Role(Integer roleId) throws Exception;

    /**
     * 根据角色名称模糊查询
     *
     * @param roleName 角色名称
     * @return
     */
    List<SmbmsRole> list_findByName(String roleName) throws Exception;
}
