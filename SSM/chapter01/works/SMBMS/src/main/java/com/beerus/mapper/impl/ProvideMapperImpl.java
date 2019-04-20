package com.beerus.mapper.impl;

import com.beerus.entity.SmbmsProvider;
import com.beerus.mapper.ProvideMapper;
import com.beerus.utils.MyBatisUtil;
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

    public List<SmbmsProvider> list_FindAll() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            //返回查询之后的集合
            return sqlSession.getMapper(ProvideMapper.class).list_FindAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }
}
