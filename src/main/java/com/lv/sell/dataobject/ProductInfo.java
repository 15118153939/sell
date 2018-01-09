package com.lv.sell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lv.sell.enums.ProductStatusEnum;
import com.lv.sell.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/21 22:02
 * @Description
 **/
@Entity
@Data
@DynamicUpdate //时间自动更新
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
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /**类目编号。做关联*/
    private Integer categoryType;
    /**商品描述*/
    private String productDescription;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更改时间
     */
    private Date updateTime;


    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
