package com.lv.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/9 9:49
 * @Description
 * 专门用来保存form的
 **/
@Data
public class ProductForm {

    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 类目编号. */
    private Integer categoryType;

//    不需要状态。。
}
