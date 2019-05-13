package com.beerus.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @Author Beerus
 * @Description 文件上传控制
 * @Date 2019-05-08
 **/
@Controller
@RequestMapping(value = "/fileUpload")
public class FileController {

    @RequestMapping(value = "/upload")
    public String file(@RequestParam(value = "uploadIMG", required = false) MultipartFile multipartFile,
                       HttpServletRequest request) throws IOException {
        //错误信息
        String errorMsg = "";
        //判断是否上传文件
        if (multipartFile.isEmpty()) {
            //文件不存在
            errorMsg = "file is empty!";
        } else {
            //文件存在执行对应的判断在进行上传
            int fileSize = 400000;
            //判断文件大小
            if (multipartFile.getSize() >= fileSize) {
                //超出大小
                errorMsg = "文件大小只可以为500KB的";
            } else {
                //后缀名  //原文件名 multipartFile.getOriginalFilename()
                String suffix = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
                if (!("jpg".equalsIgnoreCase(suffix) ||
                        "peng".equalsIgnoreCase(suffix) ||
                        "img".equalsIgnoreCase(suffix) ||
                        "png".equalsIgnoreCase(suffix))) {

                    errorMsg = "文件类型只可以为jpg、peng、img、png";
                } else {
                    //源文件名
                    String oldFileName = multipartFile.getOriginalFilename();
                    //新文件名
                    String newFileName = System.currentTimeMillis() + "." + suffix;
                    //获取路径
                    String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "images") + File.separator;
                    //上传文件
                    //上传文件内容  path Copy的路径
                    multipartFile.transferTo(new File(path + newFileName));
                    request.setAttribute("fileName", newFileName);
                    //返回显示图片页面
                    return "show";
                }
            }
        }
        request.setAttribute("error", errorMsg);
        return "index";
    }

    @RequestMapping(value = "/index.html")
    public String index() {
        return "index";
    }

    /**
     * 捕获异常信息
     *
     * @return
     */

    @ExceptionHandler(value = {MaxUploadSizeExceededException.class})
    public String error(MaxUploadSizeExceededException e, HttpServletRequest request) {
        request.setAttribute("error", e.getMessage());
        return "index";
    }

    @RequestMapping(value = "/test")
    public String test(@RequestParam(value = "id") Integer id) {
        Integer ID = id;
        return null;
    }
}
