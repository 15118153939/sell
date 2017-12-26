package com.lv.sell.service;

import com.lv.sell.dataobject.ProductInfo;
import com.lv.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/21 22:56
 * @Description
 **/
public interface ProductService {

    ProductInfo findOne(String productId);
    /**查询在家商品列表*/
    List<ProductInfo> findUpAll();

    /**分页*/
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    List<ProductInfo> findAll();

    /**加库存*/
    void increaseStock(List<CartDTO> cartDTOList);

    /***减少库存*/
    void decreaseStock(List<CartDTO> cartDTOList);

}
