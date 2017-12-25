package com.lv.sell.service;

import com.lv.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/21 21:21
 * @Description
 **/
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    /**新增，和修改*/
    ProductCategory save(ProductCategory productCategory);
}
