package com.beerus.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beerus.entity.SaleOrder;
import com.beerus.entity.SaleOrderLine;
import com.beerus.entity.SaleProduct;
import com.beerus.service.SaleService;
import com.beerus.service.impl.SaleServiceImpl;
import com.beerus.utils.HibernateUtils;
import com.beerus.utils.Result;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Beerus
 * @Description 订单Acion
 * @Date 2019/4/11
 **/
public class OrderAction extends ActionSupport {
    private SaleService saleService = new SaleServiceImpl();
    //订单
    private SaleOrder item;
    //订单详细信息
    private SaleOrderLine line;
    //订单类型
    private List<SaleProduct> prodList;

    public SaleOrderLine getLine() {
        return line;
    }

    public void setLine(SaleOrderLine line) {
        this.line = line;
    }

    private SaleProduct saleProduct;

    public SaleProduct getSaleProduct() {
        return saleProduct;
    }

    public void setSaleProduct(SaleProduct saleProduct) {
        this.saleProduct = saleProduct;
    }

    public List<SaleProduct> getProdList() {
        return prodList;
    }

    public void setProdList(List<SaleProduct> prodList) {
        this.prodList = prodList;
    }

    public SaleOrder getItem() {
        return item;
    }

    public void setItem(SaleOrder item) {
        this.item = item;
    }

    /**
     * 添加订单
     *
     * @return
     */
    public String add_Order() {
        //默认未发货
        item.setOdrStatus("未发货");
        //判断是否添加成功
        if (saleService.save(item)) {
            //查询产品类型
            prodList = saleService.searchFindAll();
            return SUCCESS;
        }
        return ERROR;
    }

    public String doAdd_Order() {
        //添加详情 使用级联操作保存数据
        PrintWriter writer = null;
        try {
            writer = ServletActionContext.getResponse().getWriter();
            //使用级联操作添加房屋
            SaleOrder saleOrder = saleService.findOrder(SaleOrder.class, item.getOdrId());
            line.setSaleOrder(saleOrder);
            saleOrder.getSaleOrderLines().add(line);
            //输出是否添加成功
            Result<SaleOrderLine> result = new Result(1001, "success");
            //输出数据
            result.setSaleOrderLines(saleOrder.getSaleOrderLines());
            HibernateUtils.getSession().flush();
            writer.print(JSON.toJSONString(result));
        } catch (Exception e) {
            //出现异常 添加失败
            writer.print(JSON.toJSONString(new Result(1000, "error")));
        } finally {
            if (null != writer)
                writer.close();
        }
        return null;
    }
}
