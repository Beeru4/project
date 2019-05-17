package com.beerus.mapper;

import com.beerus.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Beerus
 * @Description 开发用户者数据层
 * @Date 2019-05-15
 **/
public interface DevUserMapper {
    /**
     * 根据开发者编码和密码返回开发者用户
     *
     * @param devCode     开发者编码
     * @param devPassword 开发者密码
     * @return
     */
    DevUser getDevUser(@Param(value = "devCode") String devCode, @Param(value = "devPassword") String devPassword) throws Exception;
}
