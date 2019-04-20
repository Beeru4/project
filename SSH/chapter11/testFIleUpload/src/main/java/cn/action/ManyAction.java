package cn.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;

/**
 * @Author Beerus
 * @Description 多个文件上传
 * @Date 2019/4/9
 **/
public class ManyAction extends ActionSupport {
    //上传的文件
    private File[] img_file;
    //上传的文件名
    private String[] img_fileFileName;
    //上传的文件类型
    private String[] img_fileContentType;
    //上传的路径 由struts配置
    private String savePath;

    public File[] getImg_file() {
        return img_file;
    }

    public void setImg_file(File[] img_file) {
        this.img_file = img_file;
    }

    public String[] getImg_fileFileName() {
        return img_fileFileName;
    }

    public void setImg_fileFileName(String[] img_fileFileName) {
        this.img_fileFileName = img_fileFileName;
    }

    public String[] getImg_fileContentType() {
        return img_fileContentType;
    }

    public void setImg_fileContentType(String[] img_fileContentType) {
        this.img_fileContentType = img_fileContentType;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    @Override
    public String execute() throws Exception {
        //得到真实地址
        String path = ServletActionContext.getRequest().getRealPath(savePath);
        //循环上传文件
        for (int i = 0; i < img_file.length; i++) {
            if (null != img_file[i]) {
                //进行上传
                FileUtils.copyFile(img_file[i], new File(path + File.separator + img_fileFileName[i]));
            }
        }
        return super.SUCCESS;
    }
}
