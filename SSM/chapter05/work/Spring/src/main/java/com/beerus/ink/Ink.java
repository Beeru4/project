package com.beerus.ink;

/**
 * 墨盒规范
 */
public interface Ink {
    /**
     * 得到打印的颜色
     * @param r
     * @param g
     * @param b
     * @return
     */
    String getColor(int r, int g, int b);
}
