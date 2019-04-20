package com.beerus.action;

import com.beerus.entity.House;
import com.beerus.entity.Type;
import com.beerus.entity.Users;
import com.beerus.service.HouserService;
import com.beerus.service.TypeService;
import com.beerus.service.impl.HouseServiceImpl;
import com.beerus.service.impl.TypeServiceImpl;
import com.beerus.utils.Mark;
import com.beerus.utils.Page;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.Date;
import java.util.List;

/**
 * @Author Beerus
 * @Description 房屋Action
 * @Date 2019/4/4
 **/
public class HouseAction extends ActionSupport {
    //房屋集合
    private List<House> houseList = null;
    //房屋业务层
    private HouserService houserService = new HouseServiceImpl();
    //类型业务层
    private TypeService typeService = new TypeServiceImpl();
    //类型集合
    private List<Type> typeList = null;
    //房子
    private House params;
    //分页数据类
    private Page<House> page;
    //当前页码
    private int currPageNo = 1;
    //房子id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        this.currPageNo = currPageNo;
    }

    public Page<House> getPage() {
        return page;
    }

    public void setPage(Page<House> page) {
        this.page = page;
    }

    public List<Type> getTypeList() {
        return typeList;
    }

    public House getHouse() {
        return params;
    }

    public House getParams() {
        return params;
    }

    public void setParams(House params) {
        this.params = params;
    }

    public void setHouse(House params) {
        this.params = params;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

    public void setHouseList(List<House> houseList) {
        this.houseList = houseList;
    }

    public List<House> getHouseList() {
        return houseList;
    }

    /**
     * 查找房屋列表
     *
     * @return
     */
    public String findAll_List() {
        typeList = typeService.listFindAll();
        /*  houseList = houserService.listFindAllHouse();*/
        page = houserService.listByPageHouse(null, currPageNo, 5);
        if (null != params)
            params.getTitle().replace("%", "");
        return SUCCESS;
    }

    /**
     * 根据用查找对应的房屋列表
     *
     * @return
     */
    public String findByUserHouseList() {
        houseList = houserService.listFindByUserHouse(((Users) ServletActionContext.getRequest().getSession().getAttribute("user")).getId());
        return SUCCESS;
    }

    /**
     * 根据条件查找筛选房源
     *
     * @return
     */
    public String findByCondition_List() {
        typeList = typeService.listFindAll();
        /* houseList = houserService.listByConditionHouse(params);*/
        page = houserService.listByPageHouse(params, currPageNo, 5);
        if (null != params)
            params.setTitle(params.getTitle().replace("%", ""));
        return SUCCESS;
    }

    /**
     * 查看详情页
     *
     * @return
     */
    public String show_House() {
        //根据id查询点那个
        params = houserService.getHouseById(id);
        return SUCCESS;
    }

    /**
     * 添加房屋信息
     *
     * @return 是否添加成功
     */
    public String add_House() {
        //设置发布时间
        this.params.setPubdate(new Date());
        //设置用户id
        this.params.setUsers((Users) ServletActionContext.getRequest().getSession().getAttribute("user"));
        if (houserService.saveHouse(params) > Mark.ERROR_I) {
            return "addHouse";
        }

        return "list";
    }
}
