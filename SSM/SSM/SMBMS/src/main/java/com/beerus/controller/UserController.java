package com.beerus.controller;

import com.alibaba.fastjson.JSON;
import com.beerus.entity.User;
import com.beerus.service.RoleService;
import com.beerus.service.UserService;
import com.beerus.utils.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Beerus
 * @Description 用户管理控制层
 * @Date 2019/4/24
 **/
@Controller
@RequestMapping(value = "/sys/user")
public class UserController {

    /**
     * 用户数据层
     */
    @Resource(name = "userService")
    private UserService userService;
    /**
     * 角色数据层
     */
    @Resource(name = "roleService")
    private RoleService roleService;


    /**
     * 检查密码是否一致
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/checkedOldPwd", method = RequestMethod.GET)
    @ResponseBody
    public Model checkPwd(@RequestParam(value = "oldpassword", required = false) String oldPassword, HttpSession session, Model model) throws Exception {
        Object user = session.getAttribute("user");
        //结果
        Map result = new HashMap<String, Object>(1);
        String msg;
        if (null == oldPassword) {
            //密码为空
            msg = "error";
        } else if (null == user) {
            //用户为空
            msg = "sessionerror";
        } else if (((User) user).getUserPassword().equals(oldPassword.trim())) {
            //密码一致
            msg = "true";
        } else {
            //密码不一致
            msg = "false";
        }
        result.put("result", msg);
        model.addAttribute("key", result);
        return model;
    }

    /**
     * 修改密码
     *
     * @return
     */
    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
    public String updatePwd(@RequestParam(value = "rnewpassword", required = false) String rnewPassword, HttpSession session) throws Exception {
        if (null == rnewPassword || "".equals(rnewPassword)) {
            return null;
        }
        User user = (User) session.getAttribute("user");
        if (null != rnewPassword) {
            //修改密码
            if (this.userService.updatePassword(user.getId(), rnewPassword)) {
                //修改成功 修改会话当中的密码
                user.setUserPassword(rnewPassword);
                return "redirect:/sys/index.html";
            } else {
                //修改失败
                return "pwdmodify";
            }
        }
        return "pwdmodify";
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @RequestMapping(value = "/userlist.html")
    public String list_User(@RequestParam(value = "pageIndex", required = false, defaultValue = "1") final Integer pageIndex,
                            @RequestParam(value = "queryname", required = false) final String queryName,
                            @RequestParam(value = "queryUserRole", required = false) final Integer queryUserRole, HttpServletRequest request) throws Exception {
        //获取分页对象
        Page<User> userPage = userService.list_FindAll(new HashMap<String, Object>(4) {{
            put("currPageNo", pageIndex);
            put("pageSize", 10);
            put("userName", queryName);
            put("userRole", queryUserRole);
        }});
        //设置当前页码
        request.setAttribute("currentPageNo", pageIndex);
        //设置总行数
        request.setAttribute("totalCount", userPage.getTotalCount());
        //设置总页码
        request.setAttribute("totalPageCount", userPage.getTotalPage());
        //设置查询用户名
        request.setAttribute("queryname", queryName);
        //设置查询角色
        request.setAttribute("queryUserRole", queryUserRole);
        //设置查询用户数据
        request.setAttribute("userList", userPage.getPages());
        //查询角色数据
        request.setAttribute("roleList", roleService.list_Role());
        return "userlist";
    }

    /**
     * 使用表述性状态转移(REST)查看用户
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/userview/{uid}")
    public String view_User(@PathVariable(value = "uid") Integer uId, Model model) throws Exception {
        if (null != uId && uId > 0) {
            //执行查询
            User user = userService.get_UserById(uId);
            if (null != user) {
                //保存到数据模型
                model.addAttribute("user", user);
                return "userview";
            }
        }
        return "redirect:/sys/user/userlist.html";
    }

    /**
     * 删除用户
     *
     * @return
     */
    @RequestMapping(value = "/delUser")
    @ResponseBody
    public Model del_User(@RequestParam(value = "uid") Integer uId, Model model) throws Exception {
        //删除结果
        Map<String, Object> result = new HashMap(1);
        if (null != uId && uId > 0) {
            //执行删除
            if (userService.delete_User(uId)) {
                //删除成功
                result.put("delResult", "true");
            } else {
                //删除失败
                result.put("delResult", "false");
            }

        }
        model.addAttribute("key", result);
        return model;
    }

    /**
     * 添加和修改之前先查询所有供应商
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getRole")
    @ResponseBody
    public Model getRole_User(Model model) throws Exception {
        //以JSON的形式返回数据
        model.addAttribute("roles", JSON.toJSON(roleService.list_Role()));
        return model;
    }

    /**
     * 验证用编码是否存在
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/ucexist")
    @ResponseBody
    public Model ucexist_User(@RequestParam(value = "userCode") String userCode, Model model) throws Exception {
        //是否存在
        Map<String, Object> result = new HashMap(1);
        result.put("userCode", "exist");
        //判断用户名是否存在
        if (!userService.checkUserCode(userCode)) {
            //不存在
            result.put("userCode", "noExist");
        }
        model.addAttribute("key", result);
        return model;
    }

    /**
     * 添加用户
     *
     * @return
     */
    @RequestMapping(value = "/addUser")
    public String add_User(@Valid @ModelAttribute User user, HttpSession session) throws Exception {
        if (null != user) {
            //添加用户
            //设置创建人
            user.setCreateBy(((User) session.getAttribute("user")).getId());
            if (userService.save_User(user)) {
                //添加成功
                return "redirect:/sys/user/userlist.html";
            }
        }
        //添加失败
        return "useradd";
    }

    /**
     * 修改用户
     *
     * @return
     * @Valid
     */
    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
    public String modify_User(@ModelAttribute User user, HttpSession session) throws Exception {
        if (null != user) {
            //修改用户
            //设置修改人
            user.setModifyBy(((User) session.getAttribute("user")).getId());
            if (userService.modify(user)) {
                //修改成功
                return "redirect:/sys/user/userlist.html";
            }
        }
        //修改失败
        return "usermodify";
    }

    /**
     * 修改之前先查询
     *
     * @return
     */
    @RequestMapping(value = "/modifyBefore/{uid}")
    public String modifyBefore_User(@PathVariable(value = "uid") Integer uId, HttpServletRequest request) throws Exception {
        if (null != uId) {
            User user = userService.get_UserById(uId);
            if (null != user) {
                //保存到request作用域方便读取
                request.setAttribute("user", user);
                return "usermodify";
            }
        }
        return "redirect:/sys/user/userlist.html";
    }

}
