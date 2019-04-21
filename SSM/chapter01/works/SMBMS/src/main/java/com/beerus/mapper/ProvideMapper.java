package com.beerus.mapper;

import com.beerus.entity.SmbmsProvider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 供应商数据层
 */
public interface ProvideMapper {
    /**
     * 查询总行数
     *
     * @return
     */
    int count_TotalRow() throws Exception;

    /**
     * 查询总行数2
     *
     * @return
     */
    int count_TotalRow2() throws Exception;

    /**
     * 查询所有供应商
     *
     * @param currPageNo 当前页码
     * @param pageSize   页大小
     * @return
     * @throws Exception
     */
    List<SmbmsProvider> list_FindAll(
            @Param("currPageNo") Integer currPageNo,
            @Param("pageSize") Integer pageSize) throws Exception;

    /**
     * 添加订单
     *
     * @param smbmsProvider
     * @return
     */
    int save_Prov(SmbmsProvider smbmsProvider) throws Exception;

    /**
     * 修改订单
     *
     * @param smbmsProvider
     * @return
     */
    int update_Prov(SmbmsProvider smbmsProvider) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete_Prov(@Param("id") Integer id) throws Exception;

    /**
     * 根据条件+choose查询供应商
     *
     * @param smbmsProvider 条件
     * @return
     * @throws Exception
     */
    List<SmbmsProvider> list_FindByFilter(SmbmsProvider smbmsProvider) throws Exception;
}
