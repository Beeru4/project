package com.beerus.service;

import com.beerus.pojo.AppData;
import com.beerus.utils.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Beerus
 * @Description APP数据层
 * @Date 2019-05-16
 **/
public interface AppInfoService {
    /**
     * 根据分页和查询条件查询app详细信息
     *
     * @param appData    查询条件
     * @param currPageNo 当前页码
     * @param pageSize   也大小
     * @return
     */
    Pager<AppData> listQueryByPagerOrAndFilter(@Param(value = "appData") AppData appData,
                                               @Param(value = "currPageNo") Integer currPageNo,
                                               @Param(value = "pageSize") Integer pageSize);

    /**
     * 查询所有APP状态
     *
     * @return 状态集合
     */
    List<AppData> listQueryAllStatus();


    /**
     * 查询所有所属平台
     *
     * @return 状态集合
     */
    List<AppData> listQueryAllForm();


}