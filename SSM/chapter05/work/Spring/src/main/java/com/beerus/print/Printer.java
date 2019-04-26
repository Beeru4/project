package com.beerus.print;

import com.beerus.ink.Ink;
import com.beerus.ink.Paper;

/**
 * @Author Beerus
 * @Description 打印机类
 * @Date 2019/4/23
 **/
public class Printer {
    //面向接口变成,而不是具体的实例
    //墨盒
    private Ink ink = null;
    //纸张
    private Paper paper = null;

    //提供setter方法 使用Spring注解初始化

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    /**
     * 打印方法
     */
    public void print(String str) {
        System.out.println("使用" + ink.getColor(1, 1, 1) + "颜色打印!\n");
        //输出到纸张
        for (int i = 0; i < str.length(); i++) {
            //拆分为char类型的进行拼接
            paper.inputChar(str.charAt(i));
        }
        //输出内容
        System.out.println(paper.getContext());
    }
}
