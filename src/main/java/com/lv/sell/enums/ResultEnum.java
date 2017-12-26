package com.lv.sell.enums;

import lombok.Getter;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 20:12
 * @Description
 **/
@Getter
public enum  ResultEnum {

    PRODUCT_NOT_EXIST(10,"商品部不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不准确");
        ;


     ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;
}
