package com.lv.sell.repository;

import com.lv.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/21 17:15
 * @Description
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{

//    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
