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

    PRODUCT_STOCK_ERROR(11,"库存不准确"),

    ORDER_NOT_EXITST(12,"订单不存在"),

    ORDER_DETAIL_NOT_ESIST(13,"订单详情不存在"),

    ORDER_STATUS_ERROR(14,"订单状态不正确"),

    ORDER_UPDATE_FILE(15,"订单更新失败"),

    ORDER_DETAIL_EMPTY(16,"订单详情为空"),

    ORDER_PAY_STATUS_ERROR(17,"订单支付状态不正确"),

    PARAM_ERROR(1,"参数不正确"),

    CART_EMPTY(18,"购物车为空"),

    ORDER_OWENR_ERROR(19,"该订单不属于当前用户");
    ;






        ;


     ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;
}
