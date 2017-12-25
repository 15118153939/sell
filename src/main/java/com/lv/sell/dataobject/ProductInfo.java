package com.lv.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 商品
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/21 22:02
 * @Description
 **/
@Entity
@Data
public class ProductInfo {
    @Id
    private String productId;
    /***
     * 名字
     */
    private String productName;
    /**单价*/
    private BigDecimal productPrice;
    /**库存**/
    private Integer productStock;
    /**商品小图，是一个链接地址*/
    private String productIcon;

    /**状态：0正常，1下架*/
    private Integer productStatus;
    /**类目编号。做关联*/
    private Integer categoryType;
    /**商品描述*/
    private String productDescription;


}
