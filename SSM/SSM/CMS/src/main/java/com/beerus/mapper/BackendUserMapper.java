package com.beerus.mapper;

import com.beerus.pojo.BackendUser;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Beerus
 * @Description 后台用户数据层
 * @Date 2019-05-15
 **/
public interface BackendUserMapper {
    /**
     * 根据后台用户的编码和密码返回后台用户
     *
     * @param userCode     用户编码
     * @param userPassword 用户密码
     * @return
     * @throws
     */
    BackendUser getBackendUser(@Param(value = "userCode") String userCode,
                               @Param(value = "userPassword") String userPassword) throws Exception;
}
