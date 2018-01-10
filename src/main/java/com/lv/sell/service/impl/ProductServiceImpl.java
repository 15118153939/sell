package com.lv.sell.service.impl;

import com.lv.sell.dataobject.ProductInfo;
import com.lv.sell.dto.CartDTO;
import com.lv.sell.enums.ProductStatusEnum;
import com.lv.sell.enums.ResultEnum;
import com.lv.sell.exception.SellException;
import com.lv.sell.repository.ProductInfoRepository;
import com.lv.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/21 23:00
 * @Description
 **/
@Service
@CacheConfig(cacheNames = "prodcut")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository repository;

    @Override
//    @Cacheable(key = "123")
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
//    @CachePut(key ="123")
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public List<ProductInfo> findAll() {
        return repository.findAll();
    }

    /***
     *
     * @param cartDTOList
     */
    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
//            增加库存
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            repository.save(productInfo);
        }
    }

    /***
     *
     * @param cartDTOList
     */
    @Transactional
    @Override
    public void decreaseStock(List<CartDTO> cartDTOList) {
//减少库存
        for (CartDTO cartDTO : cartDTOList) {
//            1：查询商品
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
//2：如果商品不存在，则抛异常
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
//3库存 - 购物车的购买数量
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
//4：如果<0,就是购买数量超过库存，则抛库存错误异常
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
//            5:设置商品减少后的库存
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }

    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = repository.findOne(productId);
//     1 判断商品是否存在
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
//      2  判断商品的状态
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
//      3更新
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return repository.save(productInfo);

    }

    /**
     * 下架操作
     * @param productId
     * @return
     */
    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = repository.findOne(productId);
//     1 判断商品是否存在
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
//      2  判断商品的状态
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
//      3更新
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return repository.save(productInfo);
    }
}
