package com.lv.sell.repository;

import com.lv.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/21 22:06
 * @Description
 **/
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
/**查询上架商品
 * */
    List<ProductInfo> findByProductStatus(Integer productStatus);

}
