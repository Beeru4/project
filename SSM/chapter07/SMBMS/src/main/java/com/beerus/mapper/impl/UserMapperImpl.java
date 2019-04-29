package com.beerus.mapper.impl;

import com.beerus.common.Mark;
import com.beerus.entity.User;
import com.beerus.mapper.UserMapper;
import com.beerus.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;
import java.util.Map;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/20
 **/
public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {


    public User get_User(String code, String pwd) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(UserMapper.class).get_User(code, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }

    public int updatePwd(Integer uId, String pwd) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            int updateResult = sqlSession.getMapper(UserMapper.class).updatePwd(uId, pwd);
            //执行正确 提交事务
            sqlSession.commit();
            return updateResult;
        } catch (Exception e) {
            //出现异常 事务回复你
            if (null != sqlSession)
                sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return Mark.ERROR;
    }

    public List<User> list_FindByFilterAndPage(Map<String, Object> params) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(UserMapper.class).list_FindByFilterAndPage(params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }

    public Integer count_Row(Map<String, Object> params) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(UserMapper.class).count_Row(params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }

    public User get_UserById(Integer id) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(UserMapper.class).get_UserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }

    public Integer delete_User(Integer id) throws Exception {
        SqlSession sqlSession = null;
        Integer delResult = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            delResult = sqlSession.getMapper(UserMapper.class).delete_User(id);
            sqlSession.commit();
            return delResult;
        } catch (Exception e) {
            e.printStackTrace();
            //出现意外 事务回滚
            if (null != sqlSession)
                sqlSession.rollback();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return delResult;
    }

    public Integer count_ByCode(String code) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(UserMapper.class).count_ByCode(code);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }

    public Integer save_User(User user) throws Exception {
        Integer addResult = null;
        try {
            addResult = this.getSqlSession().getMapper(UserMapper.class).save_User(user);
            getSqlSession().commit();
            return addResult;
        } catch (Exception e) {
            e.printStackTrace();
            //出现意外 事务回滚
            if (null != getSqlSession())
                getSqlSession().rollback();
        }
        return addResult;
    }

    public Integer update_User(User user) throws Exception {
        SqlSession sqlSession = null;
        Integer updateResult = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            updateResult = sqlSession.getMapper(UserMapper.class).update_User(user);
            sqlSession.commit();
            return updateResult;
        } catch (Exception e) {
            e.printStackTrace();
            //出现意外 事务回滚
            if (null != sqlSession)
                sqlSession.rollback();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return updateResult;
    }
}
