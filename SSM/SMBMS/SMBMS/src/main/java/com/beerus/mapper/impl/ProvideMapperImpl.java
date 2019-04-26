package com.beerus.mapper.impl;

import com.beerus.common.Mark;
import com.beerus.entity.Provider;
import com.beerus.mapper.ProvideMapper;
import com.beerus.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @Author Beerus
 * @Description 映射实现类
 * @Date 2019/4/19
 **/
public class ProvideMapperImpl implements ProvideMapper {

    public List<Provider> list_FindProvAll() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(ProvideMapper.class).list_FindProvAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }

    public List<Provider> list_FindByFilterOrPage(Map<String, Object> params) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(ProvideMapper.class).list_FindByFilterOrPage(params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }

    public Provider get_Prov(Integer id) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(ProvideMapper.class).get_Prov(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }

    public Integer count_Total(Map<String, Object> params) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(ProvideMapper.class).count_Total(params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return Mark.ERROR;
    }

    public Integer save_Prov(Provider provider) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            int saveResult = sqlSession.getMapper(ProvideMapper.class).save_Prov(provider);
            //事务提交
            sqlSession.commit();
            return saveResult;
        } catch (Exception e) {
            //发生错误 事务回滚
            if (null != sqlSession)
                sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return Mark.ERROR;
    }

    public Integer update_Prov(Provider provider) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            int saveResult = sqlSession.getMapper(ProvideMapper.class).update_Prov(provider);
            //事务提交
            sqlSession.commit();
            return saveResult;
        } catch (Exception e) {
            //发生错误 事务回滚
            if (null != sqlSession)
                sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return Mark.ERROR;
    }

    public Integer delete_Prov(Integer id) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            int saveResult = sqlSession.getMapper(ProvideMapper.class).delete_Prov(id);
            //事务提交
            sqlSession.commit();
            return saveResult;
        } catch (Exception e) {
            //发生错误 事务回滚
            if (null != sqlSession)
                sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return Mark.ERROR;
    }

    public Integer count_ByDel(Integer id) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(ProvideMapper.class).count_ByDel(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return Mark.ERROR;
    }

    public Integer count_BySave(String code) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(ProvideMapper.class).count_BySave(code);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return  Mark.ERROR;
    }


}
