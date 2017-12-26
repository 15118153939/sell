package com.lv.sell.repository;

import com.lv.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 18:48
 * @Description
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID="110010";

    @Test
    public void findByBuyerOpenid() throws Exception {
//        分页查询
        PageRequest request = new PageRequest(2,5);

        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID,request);

        System.out.println(result.getTotalElements());
        Assert.assertNotEquals(0,result.getTotalElements());
    }

    @Test
    public void saveTest(){

//        OrderMaster orderMaster = new OrderMaster();
//        orderMaster.setOrderId("123456");
//        orderMaster.setBuyerName("王小弟");
//        orderMaster.setBuyerPhone("15118153939");
//        orderMaster.setBuyerAddress("gitHub测试地址");
//        orderMaster.setBuyerOpenid("110010");
//        orderMaster.setOrderAmount(new BigDecimal(520));


        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234568");
        orderMaster.setBuyerName("王大弟");
        orderMaster.setBuyerPhone("15118153939");
        orderMaster.setBuyerAddress("gitHub测试地址");
        orderMaster.setBuyerOpenid("110010");
        orderMaster.setOrderAmount(new BigDecimal(502));
        repository.save(orderMaster);

    }
}