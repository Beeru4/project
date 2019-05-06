package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Beerus
 * @Description 用户控制器 上机练习2
 * @Date 2019-05-05
 **/
@Controller
public class UserController {
  @RequestMapping("/index.html")
  private String index() {
    return "index";
  }
}
