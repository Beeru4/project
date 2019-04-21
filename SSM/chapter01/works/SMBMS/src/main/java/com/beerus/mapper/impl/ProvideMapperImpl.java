package com.beerus.mapper.impl;

import com.beerus.common.Mark;
import com.beerus.entity.SmbmsProvider;
import com.beerus.mapper.ProvideMapper;
import com.beerus.utils.MyBatisUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author Beerus
 * @Description 映射实现类
 * @Date 2019/4/19
 **/
public class ProvideMapperImpl implements ProvideMapper {


    public int count_TotalRow() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            //使用映射方式查询
            return sqlSession.getMapper(ProvideMapper.class).count_TotalRow();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭会话
            MyBatisUtil.closeSession(sqlSession);
        }
        return 0;
    }

    public int count_TotalRow2() throws Exception {
        SqlSession sqlSession = null;
        try {
            //不使用映射方式查询
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.selectOne("com.beerus.mapper.ProvideMapper.count_TotalRow");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭会话
            MyBatisUtil.closeSession(sqlSession);
        }
        return 0;
    }

    public List<SmbmsProvider> list_FindAll(Integer currPageNo, Integer pageSize) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            //返回查询之后的集合
            return sqlSession.getMapper(ProvideMapper.class).list_FindAll(currPageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }

    @Override
    public int save_Prov(SmbmsProvider smbmsProvider) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            int save_Result = sqlSession.getMapper(ProvideMapper.class).save_Prov(smbmsProvider);
            //提交事务
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
    public int update_Prov(SmbmsProvider smbmsProvider) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            int update_Result = sqlSession.getMapper(ProvideMapper.class).update_Prov(smbmsProvider);
            //提交事务
            sqlSession.commit();
            return update_Result;
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
    public int delete_Prov(Integer id) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            //删除
            int delete_Result = sqlSession.getMapper(ProvideMapper.class).delete_Prov(id);
            //提交事务
            sqlSession.commit();
            return delete_Result;
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
    public List<SmbmsProvider> list_FindByFilter(SmbmsProvider smbmsProvider) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            //返回查询之后的集合
            return sqlSession.getMapper(ProvideMapper.class).list_FindByFilter(smbmsProvider);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }
}
