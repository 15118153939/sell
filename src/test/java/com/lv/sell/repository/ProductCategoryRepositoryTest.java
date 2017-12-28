package com.lv.sell.repository;

import com.lv.sell.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/21 17:16
 * @Description
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOne() {
        ProductCategory productCategory = repository.findOne(1);
        log.info("pro={}", productCategory.toString());
    }

    @Test
    public void addOne() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("宅男必备");
        productCategory.setCategoryTyep(4);
        repository.save(productCategory);
    }

    @Test
    public void updateOneTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("少女系列");
        productCategory.setCategoryTyep(3);
        ProductCategory category = repository.save(productCategory);

        Assert.assertNotNull(category);
        log.info(category.toString());
    }

    @Test
    public void findByCategoryTyepInTest() {

        List<Integer> list = Arrays.asList(2, 3);
        List<ProductCategory> productCategoryList = repository.findByCategoryTyepIn(list);
        Assert.assertNotEquals(0,productCategoryList.size());
        for (int i=0;i< productCategoryList.size();i++){
            System.out.println(productCategoryList.get(i).toString());
        }
    }
}