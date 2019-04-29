package com.beerus.exception;

/**
 * 异常枚举类
 */
public enum ErrorEnum {
  REIGSTER(1000);
  private int value = 0;

  private ErrorEnum(int value) {
    this.value = value;
  }

  /**
   * 得到value属性
   *
   * @return
   */
  public int value() {
    return this.value;
  }
}
