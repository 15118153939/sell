package com.lv.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 9:15
 * @Description
 * 商品（包含类目）
 **/
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -5781325994057437801L;
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    /***
     * 商品
     */
    @JsonProperty("goods")
    private List<ProductInfoVO> productInfoVOList;
}
