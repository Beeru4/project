package com.beerus.mapper.impl;

import com.beerus.common.Mark;
import com.beerus.entity.Bill;
import com.beerus.mapper.BillMapper;
import com.beerus.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @Author Beerus
 * @Description 订单数据层实现类
 * @Date 2019/4/20
 **/
public class BillMapperImpl implements BillMapper {


    public List<Bill> list_FindBillByFilterOrPage(Map<String, Object> params) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(BillMapper.class).list_FindBillByFilterOrPage(params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }

    public int count_Total(Map<String, Object> params) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(BillMapper.class).count_Total(params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return Mark.ERROR;
    }

    public int count_ByCode(String code) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(BillMapper.class).count_ByCode(code);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return Mark.ERROR;
    }

    public int save_Bill(Bill bill) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            int addResult = sqlSession.getMapper(BillMapper.class).save_Bill(bill);
            sqlSession.commit();
            return addResult;
        } catch (Exception e) {
            e.printStackTrace();
            //出现错误 事务回滚
            if (null != sqlSession) {
                sqlSession.rollback();
            }
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return Mark.ERROR;
    }

    public Bill get_ByBillId(Integer bId) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(BillMapper.class).get_ByBillId(bId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }

    public int update_ByBillId(Bill bill) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            int addResult = sqlSession.getMapper(BillMapper.class).update_ByBillId(bill);
            sqlSession.commit();
            return addResult;
        } catch (Exception e) {
            e.printStackTrace();
            //出现错误 事务回滚
            if (null != sqlSession) {
                sqlSession.rollback();
            }
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return Mark.ERROR;
    }

    public int delete_ByBillId(Integer id) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            int addResult = sqlSession.getMapper(BillMapper.class).delete_ByBillId(id);
            sqlSession.commit();
            return addResult;
        } catch (Exception e) {
            e.printStackTrace();
            //出现错误 事务回滚
            if (null != sqlSession) {
                sqlSession.rollback();
            }
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return Mark.ERROR;
    }
}
