package cn.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Author Beerus
 * @Description 文件下载
 * @Date 2019/4/9
 **/
public class DownAction extends ActionSupport {
    //文件下载路径 对应param里的
    private String inputPath;
    //下载的文件名 传进来的
    private String fileName;
    //读取下载文件的输入流
    private InputStream inputStream;
    //下载文件的类型
    private String contentType;

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    //创建input输入流
    public InputStream getInputStream() throws Exception {
        //下载的路径
        String path = ServletActionContext.getRequest().getRealPath(inputPath);
        return new BufferedInputStream(new FileInputStream(path + File.separator + fileName));
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String execute() throws Exception {
        return super.SUCCESS;
    }
}
