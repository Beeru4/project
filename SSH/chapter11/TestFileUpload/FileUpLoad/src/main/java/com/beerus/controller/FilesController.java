package com.beerus.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @Author Beerus
 * @Description 上传多个文件
 * @Date 2019-05-08
 **/
@Controller
public class FilesController {
    /**
     * 上传多个文件
     *
     * @return
     */
    @RequestMapping(value = "uploads", method = RequestMethod.POST)
    public String uploadFiles(@RequestParam(value = "imgs", required = false) MultipartFile[] multipartFiles,
                              HttpServletRequest request) throws IOException {
        //文件个数
        int fileCount = 2;
        //记录没上传文件
        int noFileUpload = 0;
        //循环文件数组
        for (MultipartFile file : multipartFiles) {
            //判断是否上传文件
            if (!file.isEmpty()) {
                //文件数量减1
                fileCount--;
                long sieze = file.getSize();
                //文件后缀名
                String suffix = FilenameUtils.getExtension(file.getOriginalFilename());
                //执行上传文件的判断
                if ("png".equalsIgnoreCase(suffix) ||
                        "img".equalsIgnoreCase(suffix) ||
                        "jpg".equalsIgnoreCase(suffix) ||
                        "pgn".equalsIgnoreCase(suffix)) {
                    //上传文件
                    //新文件名  一般来说旧的文件名也要保存 提高用户体验
                    String newFileName = System.currentTimeMillis() + "." + suffix;
                    //服务器路径
                    String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "images" + File.separator);
                    //上传到服务器
                    file.transferTo(new File(path + newFileName));
                    //保存文件名
                    request.setAttribute("fileName" + fileCount, newFileName);
                } else {
                    request.setAttribute("noFileUpload", "第" + fileCount + "个文件格式不正确");
                }

            } else {
                //未上传的文件记数
                noFileUpload++;
            }
        }
        request.setAttribute("error", "您有" + noFileUpload + "个文件没上传");
        return "show2";

    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index() {
        return "index2";
    }

    /**
     * 上传文件出现异常
     *
     * @return
     */
    @ExceptionHandler(value = {MaxUploadSizeExceededException.class})
    public String handlerException(MaxUploadSizeExceededException e, HttpServletRequest request) {
        request.setAttribute("error", "目标文件超过540KB!");
        return "index2";
    }
}
