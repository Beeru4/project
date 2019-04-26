package com.beerus.action;

import com.beerus.entity.SmbmsBill;
import com.beerus.entity.SmbmsProvider;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/23
 **/
public class BillAction extends ActionSupport {
    private String nextPage;//下一个页面
    //订单集合
    private List<SmbmsBill> smbmsBills;

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public List<SmbmsBill> getSmbmsBills() {
        return smbmsBills;
    }

    public void setSmbmsBills(List<SmbmsBill> smbmsBills) {
        this.smbmsBills = smbmsBills;
    }

    /**
     * 查询所有订单
     *
     * @return
     */
    public String list_Bill() {

        return SUCCESS;
    }
}
