package com.beerus.mapper;

import com.beerus.entity.Role;

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
}
