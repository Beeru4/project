package com.beerus.controller;

import com.beerus.entity.Role;
import com.beerus.service.RoleService;
import com.beerus.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Beerus
 * @Description 角色控制层
 * @Date 2019-05-13
 **/
@Controller
@RequestMapping(value = "/sys/role")
public class RoleController {

    /**
     * 角色业务层
     */
    @Resource
    private RoleService roleService;

    /**
     * 查询所有角色
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/roleList.html")
    public String roleList(Model model) throws Exception {
        model.addAttribute("roleList", roleService.list_Role());
        return "rolelist";
    }

    /**
     * 查询角色
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/roleView/{roleId}")
    public String roleView(@PathVariable(value = "roleId", required = false) Integer roleId, Model model) throws Exception {
        if (null != roleId) {
            model.addAttribute("role", roleService.serachRole(roleId));
        }
        return "rolemodify";
    }

    /**
     * 修改角色
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "/roleModify")
    public String roleModify(@ModelAttribute Role role) throws Exception {
        if (null != role) {
            //修改角色
            if (roleService.modify_Role(role)) {
                //修改成功
                return "redirect:/sys/role/roleList.html";
            } else {
                //修改失败
                return "rolemodify";
            }
        }
        return "rolemodify";
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/delRole")
    @ResponseBody
    public Model delRole(@RequestParam(value = "roleId", required = false) Integer roleId, Model model) {
        if (null != roleId) {
            //删除角色
            if (roleService.delete_Role(roleId)) {
                //删除成功
                model.addAttribute(new Result(1000, "true"));
            } else {
                //删除失败
                model.addAttribute(new Result(1001, "false"));
            }
        }
        return model;
    }

    /**
     * 添加角色
     *
     * @return
     */
    @RequestMapping(value = "doAddRole")
    public String doAddRole(@ModelAttribute Role role) {
        if (null != role) {
            //执行添加
            if (roleService.add_Role(role)) {
                //添加成功
                return "redirect:/sys/role/roleList.html";
            }
        }
        //添加失败
        return "roleadd";
    }

    /**
     * 检查角色编码是否存在
     *
     * @return
     */
    @RequestMapping(value = "/checkExists")
    public Model checkRoleCode(@RequestParam(value = "roleCode", required = false) String roleCode, Model model) {
        if (null != roleCode) {
            //验证角色编码
            if (roleService.checkRoleCode(roleCode)) {
                //存在
                model.addAttribute(new Result(1000, "true"));
            } else {
                //不存在
                model.addAttribute(new Result(1001, "false"));
            }
        }
        return model;
    }

}
