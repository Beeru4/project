package com.beerus.exception;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/23
 **/
public class BeanIdNotFoundException extends RuntimeException {
    public BeanIdNotFoundException(String errorMsg) {
        super(errorMsg);
    }
}
