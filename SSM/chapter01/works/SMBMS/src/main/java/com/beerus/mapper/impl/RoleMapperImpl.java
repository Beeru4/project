package com.beerus.mapper.impl;

import com.beerus.common.Mark;
import com.beerus.entity.SmbmsRole;
import com.beerus.mapper.RoleMapper;
import com.beerus.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author Beerus
 * @Description 角色数据层实现类
 * @Date 2019/4/20
 **/
public class RoleMapperImpl implements RoleMapper {

    @Override
    public int save_Role(SmbmsRole smbmsRole) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            int save_Result = sqlSession.getMapper(RoleMapper.class).save_Role(smbmsRole);
            sqlSession.commit();
            return save_Result;
        } catch (Exception e) {
            e.printStackTrace();
            if (null != sqlSession)
                sqlSession.rollback();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return Mark.SAVE_ERROR;
    }

    @Override
    public int update_Role(SmbmsRole smbmsRole) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            int update_Result = sqlSession.getMapper(RoleMapper.class).update_Role(smbmsRole);
            sqlSession.commit();
            return update_Result;
        } catch (Exception e) {
            e.printStackTrace();
            if (null != sqlSession)
                sqlSession.rollback();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return Mark.UPDATE_ERROR;
    }

    @Override
    public SmbmsRole get_Role(Integer roleId) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(RoleMapper.class).get_Role(roleId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }

    @Override
    public int delete_Role(Integer roleId) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            int delete_Result = sqlSession.getMapper(RoleMapper.class).delete_Role(roleId);
            sqlSession.commit();
            return delete_Result;
        } catch (Exception e) {
            e.printStackTrace();
            if (null != sqlSession)
                sqlSession.rollback();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return 0;
    }

    @Override
    public List<SmbmsRole> list_findByName(String roleName) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(RoleMapper.class).list_findByName(roleName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }
}
