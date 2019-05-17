package com.beerus.service.impl;

import com.beerus.mapper.AppInfoMapper;
import com.beerus.pojo.AppData;
import com.beerus.service.AppInfoService;
import com.beerus.utils.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Beerus
 * @Description app业务层实现类
 * @Date 2019-05-16
 **/
@Service("appInfoService")
public class AppInfoServiceImpl implements AppInfoService {

    /**
     * appInfo映射接口
     */
    @Resource(name = "appInfoMapper")
    private AppInfoMapper appInfoMapper;


    public Pager<AppData> listQueryByPagerOrAndFilter(AppData appData, Integer currPageNo, Integer pageSize) {
        Pager<AppData> pager = new Pager<AppData>();
        //设置当前页码
        pager.setCurrPageNo(currPageNo);
        //设置总行数
        pager.setTotalCount(appInfoMapper.count_Rows(appData));
        //设置总页码
        pager.setTotalPage((pager.getTotalCount() + pageSize - 1) / pageSize);
        //设置页大小
        pager.setPageSize(pageSize);
        //设置查询数据
        pager.setPages(appInfoMapper.listQueryByPagerOrAndFilter(appData, (currPageNo - 1) * pageSize, pageSize));
        return pager;
    }

    public List<AppData> listQueryAllStatus() {
        return appInfoMapper.listQueryAllStatus();
    }

    public List<AppData> listQueryAllForm() {
        return appInfoMapper.listQueryAllForm();
    }

}
