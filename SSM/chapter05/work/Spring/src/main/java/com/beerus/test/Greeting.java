package com.beerus.test;

/**
 * @Author Beerus
 * @Description 说话规范类
 * @Date 2019/4/23
 **/
public class Greeting {
    private String context;//说话的内容
    private String userName;//用户名

    //提供setter方法使用spring注入赋值

    public void setContext(String context) {
        this.context = context;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 说话方法
     */
    public void speak() {
        System.out.println(this.userName + "说:" + "\"" + this.context + "\"");
    }
}
