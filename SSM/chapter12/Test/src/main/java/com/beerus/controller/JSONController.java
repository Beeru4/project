package com.beerus.controller;

import com.alibaba.fastjson.JSON;
import com.beerus.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author Beerus
 * @Description 测试JSON数据
 * @Date 2019-05-09
 **/
@Controller
public class JSONController {

    /**
     * 测试从客户端发送ajax请求服务器数据1
     * 返回数据 结果日期显示不正确 字符串显示乱码
     *
     * @param request
     * @return 可以返回String类型 也可以返回Object 类型  使用AJAX请求 需声明 @ResponseBody 否则返回的是逻辑视图名
     */
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    @ResponseBody
    public String json(HttpServletRequest request) {
        //模拟从数据库取出数据
        User user = new User();
        user.setUserName("测试用户001");
        user.setAge(19.1);
        user.setBirthday(new Date());

        //转换为JSON对象
        return JSON.toJSONString(user);
    }


    /**
     * 测试从客户端发送ajax请求服务器数据2
     * toJSONStringWithDateFormat 返回日期也还是时间戳
     *
     * @param request
     * @return 可以返回String类型 也可以返回Object 类型  使用AJAX请求 需声明 @ResponseBody 否则返回的是逻辑视图名
     */
    @RequestMapping(value = "/json2", method = RequestMethod.GET)
    @ResponseBody
    public String json2(HttpServletRequest request) {
        //模拟从数据库取出数据
        User user = new User();
        user.setUserName("测试用户001");
        user.setAge(19.1);
        user.setBirthday(new Date());

        //转换为JSON对象
        return JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd");
    }

    /**
     * 测试从客户端发送ajax请求服务器数据3
     * 解决乱码1  指定produces 响应信息 这种灵活性好 但是每个方法上都得标注
     *
     * @param request
     * @return 可以返回String类型 也可以返回Object 类型  使用AJAX请求 需声明 @ResponseBody 否则返回的是逻辑视图名
     */
    @RequestMapping(value = "/json3", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String json3(HttpServletRequest request) {
        //模拟从数据库取出数据
        User user = new User();
        user.setUserName("测试用户001");
        user.setAge(19.1);
        user.setBirthday(new Date());

        //转换为JSON对象
        return JSON.toJSONString(user);
    }

    /**
     * 测试从客户端发送ajax请求服务器数据3
     * 解决乱码2 更改springmvc-servlet.xml文件 配置消息转换器 这种是永久配置
     *
     * @param request
     * @return 可以返回String类型 也可以返回Object 类型  使用AJAX请求 需声明 @ResponseBody 否则返回的是逻辑视图名
     */
    @RequestMapping(value = "/json4.html", method = RequestMethod.GET)
    @ResponseBody
    public String json4(HttpServletRequest request) {
        //模拟从数据库取出数据
        User user = new User();
        user.setUserName("测试用户001");
        user.setAge(19.1);
        user.setBirthday(new Date());

        //转换为JSON对象
        return JSON.toJSONString(user);
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
