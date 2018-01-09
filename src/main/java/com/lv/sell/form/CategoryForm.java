package com.lv.sell.form;

import lombok.Data;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/9 10:59
 * @Description
 **/
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
