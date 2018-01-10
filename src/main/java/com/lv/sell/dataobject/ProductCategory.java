package com.lv.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/21 17:04
 * @Description
 **/
@Entity
@DynamicUpdate //动态更新时间
@Data //lombok方便get/set方式 保护get/set/tostring
public class ProductCategory implements Serializable {
    private static final long serialVersionUID = 4509228123241496832L;

//    下划线改驼峰
    /*** 类目ID.*/
    @Id
    @GeneratedValue
    private Integer categoryId;
    /**
     * 类目名称
     */
    private String categoryName;
    /**
     * 类目编号.
     */
    private Integer categoryType;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更改时间
     */
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
