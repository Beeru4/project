package com.beerus.controller;

import com.beerus.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Beerus
 * @Description 测试日期转换
 * @Date 2019-05-09
 **/
@Controller
public class DateController {




    @RequestMapping(value = "/date", method = RequestMethod.POST)
    @ResponseBody
    public String json(@ModelAttribute User user) {
        User register = user;
        return null;
    }

    /**
     * 测试多视图解析器
     *
     * @return
     */

    @RequestMapping(value = {"/test.html","/test.json","/test.pdf","test.xsl"})
    public ModelAndView testVieResolvers() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("test", "json");
        map.put("test-html", "html");
        map.put("what", "what");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject(map);
        return modelAndView;
    }

    /**
     * 跳到首页
     *
     * @return
     */
    @RequestMapping(value = "/main.html")
    public String main() {
        return "index";
    }

    /**
     * 处理错误页面
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public String handlerException(Exception e, HttpServletRequest request) {
        request.setAttribute("error", e.getMessage());
        return "index";
    }
}
