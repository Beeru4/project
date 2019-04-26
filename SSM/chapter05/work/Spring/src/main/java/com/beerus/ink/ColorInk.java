package com.beerus.ink;



import org.aspectj.lang.JoinPoint;

import java.awt.*;

/**
 * @Author Beerus
 * @Description 彩色墨盒
 * @Date 2019/4/23
 **/
public class ColorInk implements Ink {

    public String getColor(int r, int g, int b) {
        return "#" + Integer.toHexString(new Color(r, g, b).getRGB()).substring(2);
    }
}
