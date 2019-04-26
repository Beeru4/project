package com.beerus.ink;

/**
 * 纸张
 */
public interface Paper {
    //换行
    String NEWLINE = "\n";

    /**
     * 输入方法
     *
     * @param c
     */
    void inputChar(char c);

    /**
     * 得到输入的内容
     *
     * @return
     */
    String getContext();
}
