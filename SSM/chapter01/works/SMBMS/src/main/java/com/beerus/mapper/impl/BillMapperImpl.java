package com.beerus.mapper.impl;

import com.beerus.entity.SmbmsBill;
import com.beerus.mapper.BillMapper;
import com.beerus.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/20
 **/
public class BillMapperImpl implements BillMapper {

    @Override
    public List<SmbmsBill> list_ByFilter(SmbmsBill smbmsBill) throws Exception {
        SqlSession sqlSession = null;
        try {
            //, int currPageNo, int pageSize
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(BillMapper.class).list_ByFilter(smbmsBill);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }

    @Override
    public List<SmbmsBill> list_findByInAndArray(Integer[] provIds) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(BillMapper.class).list_findByInAndArray(provIds);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }

    @Override
    public List<SmbmsBill> list_findByInAndList(List<Integer> provIds) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(BillMapper.class).list_findByInAndList(provIds);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }

    @Override
    public List<SmbmsBill> list_findByInAdnMap(Map<String, Object> params) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(BillMapper.class).list_findByInAdnMap(params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }


}
