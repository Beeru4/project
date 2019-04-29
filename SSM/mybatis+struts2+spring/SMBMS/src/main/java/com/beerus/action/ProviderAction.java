package com.beerus.action;

import com.alibaba.fastjson.JSON;
import com.beerus.entity.Provider;
import com.beerus.entity.User;
import com.beerus.service.ProvideService;
import com.beerus.service.impl.ProvideServiceImpl;
import com.beerus.utils.Result;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @Author Beerus
 * @Description 供应商Action
 * @Date 2019/4/24
 **/
@Controller
@Component("providerAction")
@Scope("prototype")
public class ProviderAction extends ActionSupport {

    private String nextPage;//下一个页面
    @Resource(name = "provideService")
    private ProvideService provideService;//供应商业务层

    private Integer currPageNo = 1;//当前页码
    private String queryProCode;//供应商编码
    private String queryProName;//供应商名称
    private Integer proid;//供应商Id
    private Provider provider;//供应商
    private String proCode;//供应商编码

    /**
     * 查询所有供应商
     *
     * @return
     */
    public String list_Prov() throws Exception {
        //得到request对象
        ServletRequest request = ServletActionContext.getRequest();
        //查询所有供应商
        request.setAttribute("providerList", provideService.list_FindAll(new HashMap<String, Object>() {{
            put("currPageNo", currPageNo);
            put("pageSize", 10);
            put("proCode", queryProCode);
            put("proName", queryProName);
        }}).getPages());
        this.nextPage = "providerlist";
        return SUCCESS;
    }

    /**
     * 查看供应商
     *
     * @return
     */
    public String view_Prov() throws Exception {
        if (null != proid)
            ServletActionContext.getRequest().setAttribute("provider", provideService.view(proid));
        this.nextPage = "providerview";
        return SUCCESS;
    }

    /**
     * 添加供应商
     *
     * @return
     * @throws Exception
     */
    public String add_Prov() throws Exception {
        if (null != provider) {
            //设置创建ID
            this.provider.setCreateBy(((User) ServletActionContext.getRequest().getSession().getAttribute("user")).getId());
            if (provideService.save(this.provider)) {
                //添加成功
                return list_Prov();
            }
        }
        this.nextPage = "provideradd";
        return ERROR;
    }

    /**
     * 检查供应商编码是否存在
     *
     * @return
     * @throws Exception
     */
    public String checkCode_Prov() throws Exception {
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        //判断供应商编码是否存在
        if (!provideService.checkProCode(this.proCode)) {
            //不存在
            writer.print(JSON.toJSON(new Result(1000, "noexists")));
        } else {
            //存在
            writer.print(JSON.toJSON(new Result(1001, "exists")));
        }

        writer.close();
        return null;
    }

    /**
     * 删除供应商
     *
     * @return
     */
    public String del_Prov() throws Exception {
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        if (null != proid) {
            //执行删除
            if (provideService.delete(proid)) {
                //删除成功
                writer.print("{\"delResult\":\"true\"}");
            } else {
                //删除失败
                writer.print("{\"delResult\":\"" + provideService.count_ByDel(proid) + "\"}");
            }
        }
        writer.close();
        return null;
    }

    /**
     * 修改之前先查询
     *
     * @return
     * @throws Exception
     */
    public String viewBefore_Prov() throws Exception {
        if (null != proid)
            ServletActionContext.getRequest().setAttribute("provider", provideService.view(proid));
        this.nextPage = "providermodify";
        return SUCCESS;
    }

    /**
     * 修改供应商
     *
     * @return
     * @throws Exception
     */
    public String modify_Prov() throws Exception {
        if (null != provider) {
            //设置修改人
            this.provider.setModifyBy(((User) ServletActionContext.getRequest().getSession().getAttribute("user")).getId());
            //修改
            if (provideService.update(this.provider)) {
                //修改成功
                return list_Prov();
            }
        }
        return viewBefore_Prov();
    }

    public String getNextPage() {
        return nextPage;
    }

    public Integer getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(Integer currPageNo) {
        this.currPageNo = currPageNo;
    }

    public String getQueryProCode() {
        return queryProCode;
    }

    public void setQueryProCode(String queryProCode) {
        this.queryProCode = queryProCode;
    }

    public String getQueryProName() {
        return queryProName;
    }

    public void setQueryProName(String queryProName) {
        this.queryProName = queryProName;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }
}
