package com.lv.sell.service.impl;

import com.lv.sell.dataobject.SellerInfo;
import com.lv.sell.repository.SellerInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/9 13:25
 * @Description
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    private static final String openid ="abc";
    @Autowired
    SellerInfoRepository repository;

    @Test
    public void findSellerInfoByOpeenId() throws Exception {
        SellerInfo sellerInfo = repository.findByOpenid(openid);
        Assert.assertEquals(openid,sellerInfo.getOpenid());

    }

}