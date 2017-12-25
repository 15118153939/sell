package com.lv.sell.repository;

import com.lv.sell.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

    @Test
    public void findByBuyerOpenid() throws Exception {
    }

    @Test
    public void saveTest(){

        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("王小弟");
        orderMaster.setBuyerPhone("15118153939");
        orderMaster.setBuyerAddress("gitHub测试地址");
        orderMaster.setBuyerOpenid("110010");
        orderMaster.setOrderAmount(new BigDecimal(520));
        repository.save(orderMaster);

    }
}