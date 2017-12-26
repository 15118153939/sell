package com.lv.sell.dto;

import lombok.Data;

/**
 * 购物车
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 20:36
 * @Description
 **/
@Data
public class CartDTO {
    /**
     * 商品ID
     */
    private String productId;
    /***
     * 数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
