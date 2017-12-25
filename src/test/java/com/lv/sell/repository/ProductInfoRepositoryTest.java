package com.lv.sell.repository;

import com.lv.sell.dataobject.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/21 22:08
 * @Description
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;
    @Test
    public void saveTest(){
//
//       for (int i=0;i<5;i++){
//           ProductInfo productInfo= new ProductInfo();
//           productInfo.setProductId("123456"+i);
//           productInfo.setProductName("瘦肉粥"+i);
//           productInfo.setProductPrice(new BigDecimal(8.5+i));
//           productInfo.setProductDescription("这个很好喝"+i);
//           productInfo.setProductIcon("http://xxx.jpg");
//           productInfo.setProductStatus(0);
//           productInfo.setProductStock(100);
//           productInfo.setCategoryType(2);
//           ProductInfo result = repository.save(productInfo);
//       }

        ProductInfo productInfo= new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("瘦肉粥");
        productInfo.setProductPrice(new BigDecimal(8.5));
        productInfo.setProductDescription("这个很好喝");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);
        productInfo.setCategoryType(2);
        ProductInfo result = repository.save(productInfo);


        Assert.assertNotNull(result);
    }

    @Test
    public void update(){
        ProductInfo productInfo =repository.findOne("123456");
        productInfo.setProductStatus(1);
        repository.save(productInfo);



    }

    @Test
    public void findByProductStatus() throws Exception {

        List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }



}