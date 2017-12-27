package com.lv.sell.exception;

import com.lv.sell.enums.ResultEnum;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 20:11
 * @Description
 **/
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
