package com.beerus.mapper;

import com.beerus.entity.SmbmsUser;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Beerus
 * @Description 用户数据层
 * @Date 2019/4/20
 **/
public interface UserMapper {
    /**
     * 根据用户姓名和用户密码查询用户
     *
     * @param code 用户编码
     * @param pwd  密码
     * @return
     */
    SmbmsUser get_findByNameAndPwd(
            @Param("userCode") String code,
            @Param("password") String pwd) throws Exception;
}
