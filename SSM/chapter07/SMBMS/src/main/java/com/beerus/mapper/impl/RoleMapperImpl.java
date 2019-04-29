package com.beerus.mapper.impl;

import com.beerus.entity.Role;
import com.beerus.mapper.RoleMapper;
import com.beerus.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @Author Beerus
 * @Description 角色数据层实现类
 * @Date 2019/4/20
 **/
public class RoleMapperImpl extends SqlSessionDaoSupport implements RoleMapper {

    public List<Role> list_Role() throws Exception {
        /*SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(RoleMapper.class).list_Role();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;*/
        return this.getSqlSession().getMapper(RoleMapper.class).list_Role();
    }
}
