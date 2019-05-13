package com.beerus.service.impl;

import com.beerus.common.Mark;
import com.beerus.entity.Provider;
import com.beerus.mapper.ProvideMapper;
import com.beerus.service.ProvideService;
import com.beerus.utils.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author Beerus
 * @Description 供应商业务层实现类
 * @Date 2019/4/19
 **/
@Service("provideService")
@Transactional
public class ProvideServiceImpl implements ProvideService {

    /**
     * 供应商数据层
     */
    @Resource(name = "provideMapper")
    private ProvideMapper provideMapper;

    @Transactional(readOnly = true)
    public List<Provider> list_FindProvAll() throws Exception {
        return provideMapper.list_FindProvAll();
    }

    @Transactional(readOnly = true)
    public Page<Provider> list_FindAll(Map<String, Object> params) throws Exception {
        Page<Provider> billPage = new Page<Provider>();
        //设置页大小
        billPage.setPageSize((Integer) params.get("pageSize"));
        //设置总行数
        Integer row = provideMapper.count_Total(params);
        //有可能没查询到行数 所以进行判断
        billPage.setTotalCount(row == null ? 0 : row);
        //设置当前页码
        billPage.setCurrPageNo((((Integer) params.get("currPageNo"))) * billPage.getPageSize());
        //设置总页码
        billPage.setTotalPage((billPage.getTotalCount() + billPage.getPageSize() - 1) / billPage.getPageSize());
        //重置页码
        params.put("currPageNo", billPage.getCurrPageNo());
        //设置查询数据
        billPage.setPages(provideMapper.list_FindByFilterOrPage(params));
        return billPage;
    }

    @Transactional(readOnly = true)
    public Provider view(Integer id) throws Exception {
        //  大于0成功 小于0失败
        return provideMapper.get_Prov(id);
    }

    @Transactional(rollbackFor = {Exception.class})
    public boolean save(Provider provider) throws Exception {
        //  大于0成功 小于0失败
        return provideMapper.save_Prov(provider) > Mark.ERROR;
    }

    @Transactional(rollbackFor = {Exception.class})
    public boolean update(Provider provider) throws Exception {
        //  大于0成功 小于0失败
        return provideMapper.update_Prov(provider) > Mark.ERROR;
    }

    @Transactional(rollbackFor = {Exception.class})
    public boolean delete(Integer id) throws Exception {
        //查询返回的总行数
        Integer count = this.count_ByDel(id);
        //判断该供应商下是否有订单
        if (null != count && count > Mark.ERROR) {
            //存在订单 不能删除
            return false;
        } else {
            //不存在 执行 删除
            //判断删除结果
            if (provideMapper.delete_Prov(id) > Mark.ERROR) {
                //删除成功
                return true;
            } else {
                //删除失败
                return false;
            }
        }
    }

    @Transactional(readOnly = true)
    public boolean checkProCode(String code) throws Exception {
        //true 存在 false不存在
        return provideMapper.count_BySave(code) > Mark.ERROR;
    }

    @Transactional(readOnly = true)
    public Integer count_ByDel(Integer id) throws Exception {
        return provideMapper.count_ByDel(id);
    }


}
