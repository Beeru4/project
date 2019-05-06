package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Beerus
 * @Description 上机练习3
 * @Date 2019-05-05
 **/
@Controller
@RequestMapping(value = "/user")
public class SubmitController {
  /**
   * 映射完的路径则是 /user/submit.html
   *
   * required 代表不一定要传入参数 defaultValue = "用户没有输入编码" 默认值
   *
   * @param userCode 传进来的参数
   * @param model    返回的模型数据
   * @return 视图名称
   */
  @RequestMapping(value = "/submit",method = RequestMethod.GET)
  private String submit(
        @RequestParam(required = false,
          name = "userCode",
          defaultValue = "用户没有输入编码") String userCode, Model model) {
    model.addAttribute("userCode", userCode);
    return "test";
  }

  @RequestMapping(value = "/index.html")
  public String index(){
    return "submit";
  }
}
