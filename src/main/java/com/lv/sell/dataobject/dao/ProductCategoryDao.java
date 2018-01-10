package com.lv.sell.dataobject.dao;

import com.lv.sell.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/9 20:17
 * @Description
 **/
public class ProductCategoryDao {

    @Autowired
    ProductCategoryMapper mapper;

    public int insertByMap(Map<String, Object> map) {
        return mapper.insertByMap(map);
    }

}
