package com.beerus.mapper;

import com.beerus.entity.SmbmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Beerus
 * @Description 角色数据层
 * @Date 2019/4/20
 **/
public interface RoleMapper {
    /**
     * 添加角色信息
     *
     * @param smbmsRole 角色信息
     * @return
     */
    int save_Role(SmbmsRole smbmsRole) throws Exception;

    /**
     * 修改角色信息
     *
     * @param smbmsRole 角色信息
     * @return
     */
    int update_Role(SmbmsRole smbmsRole) throws Exception;

    /**
     * 根据ID查询角色
     *
     * @param roleId 角色ID
     * @return
     */
    SmbmsRole get_Role(@Param("id") Integer roleId) throws Exception;

    /**
     * 删除角色
     *
     * @param roleId 角色ID
     * @return
     */
    int delete_Role(@Param("id") Integer roleId) throws Exception;

    /**
     * 根据角色名称模糊查询
     *
     * @param roleName 角色名称
     * @return
     */
    List<SmbmsRole> list_findByName(@Param("name") String roleName) throws Exception;
}
