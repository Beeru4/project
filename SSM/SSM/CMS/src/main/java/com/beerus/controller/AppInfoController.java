package com.beerus.controller;

import com.beerus.pojo.AppData;
import com.beerus.service.AppCategoryService;
import com.beerus.service.AppInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author Beerus
 * @Description app控制器
 * @Date 2019-05-16
 **/
@Controller
@RequestMapping(value = "/sys/dev/flatform/app")
public class AppInfoController {

    /**
     * app业务层
     */
    @Resource(name = "appInfoService")
    private AppInfoService appInfoService;
    /**
     * 级别业务层
     */
    @Resource(name = "appCategoryService")
    private AppCategoryService appCategoryService;


    @RequestMapping(value = "/list")
    public String listAppInfo(@ModelAttribute(value = "appData") AppData appData, Model model,
                              @RequestParam(value = "currPageNo", required = false, defaultValue = "1") Integer currPageNo,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        //查找分页对象
        model.addAttribute("pages", appInfoService.listQueryByPagerOrAndFilter(appData, currPageNo, pageSize));
        //查询状态列表
        model.addAttribute("statusList", appInfoService.listQueryAllStatus());
        //查询所属平台
        model.addAttribute("flatFormList", appInfoService.listQueryAllForm());
        //查询所属平台
        model.addAttribute("categoryLevel1List", appCategoryService.listQueryLevel(1, null));

        //把查询条件传回页面
        model.addAttribute("softwareName", appData.getSoftwareName());
        model.addAttribute("stautsId", appData.getStautsId());
        model.addAttribute("flatformid", appData.getFlatformid());
        model.addAttribute("level1Id", appData.getLevel1Id());
        model.addAttribute("level2Id", appData.getLevel2Id());
        model.addAttribute("level3Id", appData.getLevel3Id());
        return "/developer/appinfolist";
    }

    /**
     * 查询分类
     *
     * @param levelId
     * @return
     */
    @RequestMapping(value = "/categorylevellist")
    @ResponseBody
    public Model listLevel2(@RequestParam(value = "pid", required = false) Integer levelId, Model model) {
        if (null == levelId) {
            return null;
        }
        //设置查询数据
        model.addAttribute("level1List", appCategoryService.listQueryLevel(2, levelId));
        return model;
    }

}
