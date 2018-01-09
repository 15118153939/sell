package com.lv.sell.service.impl;

import com.lv.sell.dataobject.ProductCategory;
import com.lv.sell.repository.ProductCategoryRepository;
import com.lv.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/21 21:38
 * @Description
 **/
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private ProductCategoryRepository repository;
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }


}
