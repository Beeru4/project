package com.beerus.mapper;

import com.beerus.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Beerus
 * @Description 角色数据层
 * @Date 2019/4/20
 **/
public interface RoleMapper {
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
    Integer delete_Role(Integer roleId);

    /**
     * 修改角色
     *
     * @param role
     * @return
     */
    Integer update_Role(Role role);

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    Integer save_Role(Role role);

    /**
     * 验证角色编码是否一致
     *
     * @param roleCode
     * @return
     */
    Integer count_role(String roleCode);

    /**
     * 删除角色的查询该角色是否被引用
     *
     * @param rId
     * @return
     */
    Integer count_roleByDel(Integer rId);

    /**
     * 根据ID查询角色
     *
     * @param roleId
     * @return
     */
    Role get_Role(Integer roleId);
}
