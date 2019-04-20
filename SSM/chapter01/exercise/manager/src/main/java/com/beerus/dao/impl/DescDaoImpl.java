package com.beerus.dao.impl;

import com.beerus.dao.DescDao;
import com.beerus.entity.Desc;
import com.beerus.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 详情详细数据层
 */
public class DescDaoImpl implements DescDao {

    public List<Desc> list_All() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            //查询数据
            return sqlSession.getMapper(DescDao.class).list_All();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                MyBatisUtil.closeSqlSession(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
