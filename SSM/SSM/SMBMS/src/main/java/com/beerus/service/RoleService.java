package com.beerus.service;


import com.beerus.entity.Role;

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
}
