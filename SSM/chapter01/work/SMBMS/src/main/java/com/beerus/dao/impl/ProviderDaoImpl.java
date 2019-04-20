package com.beerus.dao.impl;

import com.beerus.dao.ProviderDao;
import com.beerus.dao.mapper.ProviderMapper;
import com.beerus.entity.SmbmsProvider;
import com.beerus.utils.MyBatisUtil;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author Beerus
 * @Description 数据层实现类
 * @Date 2019/4/18
 **/
public class ProviderDaoImpl implements ProviderDao {

    public int count_Total() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.selectOne("com.beerus.dao.mapper.ProviderMapper.count_Prov");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                MyBatisUtil.closeSession(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public List<SmbmsProvider> listALlProvByMapperXML() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            //查询
            return sqlSession.selectList("com.beerus.dao.mapper.ProviderMapper.list_AllProv");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                MyBatisUtil.closeSession(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<SmbmsProvider> listAllProv() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(ProviderMapper.class).list_AllProv();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                MyBatisUtil.closeSession(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
