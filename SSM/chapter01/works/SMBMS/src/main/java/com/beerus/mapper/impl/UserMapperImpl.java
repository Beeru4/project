package com.beerus.mapper.impl;

import com.beerus.entity.SmbmsUser;
import com.beerus.mapper.UserMapper;
import com.beerus.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/20
 **/
public class UserMapperImpl implements UserMapper {

    @Override
    public SmbmsUser get_findByNameAndPwd(String code, String pwd) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            return sqlSession.getMapper(UserMapper.class).get_findByNameAndPwd(code, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(sqlSession);
        }
        return null;
    }
}
