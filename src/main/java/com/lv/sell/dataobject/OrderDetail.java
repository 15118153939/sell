package com.lv.sell.dataobject;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 12:44
 * @Description
 **/
@Entity
@Data
public class OrderDetail {

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
    private String prductId;

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
