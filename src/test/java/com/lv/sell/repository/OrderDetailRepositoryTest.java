package com.lv.sell.repository;

import com.lv.sell.dataobject.OrderDetail;
import org.aspectj.weaver.ast.Or;
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
 * @Date 2017/12/25 19:17
 * @Description
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailsList = repository.findByOrderId("1514211912917356065");

        for (int i = 0; i < orderDetailsList.size(); i++) {
            System.out.println(orderDetailsList.get(i).toString());
        }

        System.out.println("-------"+orderDetailsList.size());
//        Assert.assertNotEquals(0,orderDetailsList.size());
//        repository.findAll();
    }

    @Test
    public void saveTest(){
        OrderDetail orderDetail= new OrderDetail();
        orderDetail.setDetailId("11245");
        orderDetail.setOrderId("1115");
        orderDetail.setProductId("1234567");
        orderDetail.setProductIcon("http://xxx.png");
        orderDetail.setProductName("小米粥");
        orderDetail.setProductPrice(new BigDecimal(12));
        orderDetail.setProductQuantity(3);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);

    }

}