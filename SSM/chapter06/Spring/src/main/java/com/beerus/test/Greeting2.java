package com.beerus.test;

/**
 * @Author Beerus
 * @Description 说话规范类(使用p标签注入, p命名空间依赖setter方法)
 * @Date 2019/4/23
 **/
public class Greeting2 {
    private String context;//说话的内容
    private String userName;//用户名


    public Greeting2() {
    }

    //提供setter方法注入

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
