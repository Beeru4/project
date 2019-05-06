package com.beerus.controller;

import com.beerus.service.DescService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @Author Beerus
 * @Description 控制层
 * @Date 2019-05-05
 **/
@Controller
@RequestMapping(value = "/desc")
public class DescController {
    @Resource(name = "descService")
    private DescService descService;

    /**
     * 查询数据并返回页面
     *
     * @return
     */
    @RequestMapping(value = "/descList.html", method = RequestMethod.GET)
    private ModelAndView descList() {
        //创建返回对象
        ModelAndView modelAndView = new ModelAndView();
        //设置视图名称
        modelAndView.setViewName("index");
        //设置模型数据
        modelAndView.addObject("descList", descService.list_All());
        return modelAndView;
    }
}
