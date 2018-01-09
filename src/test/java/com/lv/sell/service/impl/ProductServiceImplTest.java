package com.lv.sell.service.impl;

import com.lv.sell.dataobject.ProductInfo;
import com.lv.sell.enums.ProductStatusEnum;
import com.lv.sell.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/21 23:08
 * @Description
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productService.findOne("1515397914682474277");
//        ProductInfo productInfo = productService.findOne("1234569");

        Assert.assertEquals("123456", productInfo.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {

        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest request = new PageRequest(0, 10);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        log.info("!!={}", productInfoPage.getTotalElements());
        Assert.assertNotEquals(0, productInfoPage.getTotalElements());
    }

    @Test
    public void save() throws Exception {

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(18.5));
        productInfo.setProductDescription("这个瞎子好喝");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);
        productInfo.setCategoryType(2);

        productService.save(productInfo);

    }

    @Test
    public void getAddress() {
        try {
            System.out.println(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void onSale() {

        ProductInfo productInfo = productService.onSale("1515397914682474277");
        Assert.assertEquals(ProductStatusEnum.UP,productInfo.getProductStatus());
    }
    @Test
    public void offSale(){
        ProductInfo productInfo = productService.offSale("1515397914682474277");
        Assert.assertEquals(ProductStatusEnum.DOWN.getCode(),productInfo.getProductStatus());
    }

}