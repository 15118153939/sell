package com.lv.sell.enums;

import lombok.Getter;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 12:36
 * @Description
 **/
@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消");

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static OrderStatusEnum getOrderStatusEnum(Integer code) {
        for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
            if (orderStatusEnum.getCode().equals(code)) {
                return orderStatusEnum;
            }
        }
        return null;
    }
}
