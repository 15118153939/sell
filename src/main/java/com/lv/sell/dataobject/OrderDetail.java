package com.lv.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 12:44
 * @Description
 **/
@Entity
@Data
public class OrderDetail implements Serializable {


    private static final long serialVersionUID = 2968632236188036949L;
    /**
     *
     */
    @Id
    private String detailId;
    /***
     * 订单ID
     */
    private String orderId;
    /***
     * 商品ID
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品单价
     */
    private BigDecimal productPrice;

    /***
     * 商品数量
     */

    private Integer productQuantity;

    /***
     * 商品小图
     */
    private String productIcon;


}
