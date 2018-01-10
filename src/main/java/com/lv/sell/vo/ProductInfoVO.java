package com.lv.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 9:19
 * @Description 商品详情
 **/
@Data
public class ProductInfoVO implements Serializable{

    private static final long serialVersionUID = 5570479605804451719L;
    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
