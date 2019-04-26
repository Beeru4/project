package com.beerus.test;

/**
 * @Author Beerus
 * @Description 说话规范类(使用构造函数注入)
 * @Date 2019/4/23
 **/
public class Greeting {
    private String context;//说话的内容
    private String userName;//用户名


    public Greeting() {
    }


    //提供构造函数方法使用spring注入赋值

    public Greeting(String userName, String context) {
        this.userName = userName;
        this.context = context;
    }


    /**
     * 说话方法
     */
    public void speak() {
        System.out.println(this.userName + "说:" + "\"" + this.context + "\"");
    }
}
