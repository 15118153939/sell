package com.lv.sell.enums;

import lombok.Getter;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 12:36
 * @Description
 **/
@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功");

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message){
        this.code=code;
        this.message=message;
    }
}
