package com.beerus.action;

import com.alibaba.fastjson.JSON;
import com.beerus.entity.User;
import com.beerus.service.RoleService;
import com.beerus.service.UserService;
import com.beerus.service.impl.RoleServiceImpl;
import com.beerus.service.impl.UserServiceImpl;
import com.beerus.utils.Page;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @Author Beerus
 * @Description 用户管理Action
 * @Date 2019/4/24
 **/
public class UserMgrAction extends ActionSupport {

    private String nextPage;//下一个页面
    private UserService userService = new UserServiceImpl();//用户数据层
    private RoleService roleService = new RoleServiceImpl();//角色数据层

    private Integer currPageNo;//当前页码(显示的时候使用)
    private String queryname;//用户名
    private Integer queryUserRole;//角色ID
    private Integer totalPageCount;//总页码
    private Integer currentPageNo;//当前页码
    private Integer totalCount;//总行数
    private Integer pageIndex = 1;//当前页码(跳转的时候使用)
    private Integer uid;//用户ID
    private String userCode;//用户编码
    private User user;//用户

    /**
     * 查询所有用户
     *
     * @return
     */
    public String list_User() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        //查询角色
        request.setAttribute("roleList", roleService.list_Role());

        //获取分页对象
        Page<User> userPage = userService.list_FindAll(new HashMap<String, Object>() {{
            put("currPageNo", pageIndex);
            put("pageSize", 10);
            put("userName", queryname);
            put("userRole", queryUserRole);
        }});
        //设置当前页码
        this.currentPageNo = pageIndex;
        //设置总行数
        this.totalCount = userPage.getTotalCount();
        //设置总页码
        this.totalPageCount = userPage.getTotalPage();
        //设置查询用户数据
        request.setAttribute("userList", userPage.getPages());
        this.nextPage = "userlist";
        return SUCCESS;
    }

    /**
     * 查看用户
     *
     * @return
     * @throws Exception
     */
    public String view_User() throws Exception {
        if (null != this.uid && this.uid > 0) {
            //执行查询
            User user = userService.get_UserById(this.uid);
            if (null != user) {
                ServletActionContext.getRequest().setAttribute("user", user);
                this.nextPage = "userview";
                return SUCCESS;
            }
        }

        return list_User();
    }

    /**
     * 删除用户
     *
     * @return
     */
    public String del_User() throws Exception {
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        String result = "{\"notexist\":\"true\"}";//删除结果
        if (null != uid && uid > 0) {
            //执行删除
            if (userService.delete_User(this.uid)) {
                //删除成功
                result = "{\"delResult\":\"true\"}";
            } else {
                //删除失败
                result = "{\"delResult\":\"true\"}";
            }
        }
        writer.print(result);
        writer.close();
        return null;
    }

    /**
     * 添加之前先查询所有供应商
     *
     * @return
     * @throws Exception
     */
    public String getRole_User() throws Exception {
        ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        writer.print(JSON.toJSON(roleService.list_Role()));
        writer.close();
        return null;
    }

    /**
     * 验证用编码是否存在
     *
     * @return
     * @throws Exception
     */
    public String ucexist_User() throws Exception {
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        String result = "{\"userCode\":\"exist\"}";//是否存在
        //潘段用户名是否存在
        if (!userService.checkUserCode(userCode)) {
            result = "{\"userCode\":\"noExist\"}";
        }
        writer.print(result);
        writer.close();
        return null;
    }

    /**
     * 添加用户
     *
     * @return
     */
    public String add_User() throws Exception {
        if (null != this.user) {
            //添加用户
            //设置创建人
            this.user.setCreateBy(((User) ServletActionContext.getRequest().getSession().getAttribute("user")).getId());
            if (userService.save_User(this.user)) {
                this.nextPage = "userlist";
                return list_User();
            }
        }
        //添加失败
        this.nextPage = "useradd";
        return ERROR;
    }

    /**
     * 修改用户
     *
     * @return
     */
    public String modify_User() throws Exception {
        if (null != this.user) {
            //修改用户
            //设置修改人
            this.user.setModifyBy(((User) ServletActionContext.getRequest().getSession().getAttribute("user")).getId());
            if (userService.modify(this.user)) {
                return list_User();
            }
        }
        //修改失败
        this.nextPage = "usermodify";
        return ERROR;
    }

    /**
     * 修改之前先查询
     *
     * @return
     */
    public String modifyBefore_User() throws Exception {
        if (null != this.uid) {
            User user = userService.get_UserById(this.uid);
            if (null != user) {
                ServletActionContext.getRequest().setAttribute("user", user);
                this.nextPage = "usermodify";
                return SUCCESS;
            }
        }
        return list_User();
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

    public String getQueryname() {
        return queryname;
    }

    public void setQueryname(String queryname) {
        this.queryname = queryname;
    }

    public Integer getQueryUserRole() {
        return queryUserRole;
    }

    public void setQueryUserRole(Integer queryUserRole) {
        this.queryUserRole = queryUserRole;
    }

    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public Integer getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(Integer currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
