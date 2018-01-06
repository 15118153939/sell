package com.lv.sell.service.impl;

import com.lly835.bestpay.model.PayResponse;
import com.lv.sell.dto.OrderDTO;
import com.lv.sell.service.OrderService;
import com.lv.sell.service.PayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/29 9:40
 * @Description
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class PayServiceImplTest {

    @Autowired
    private PayService payService;
    @Autowired
    private OrderService orderService;
    @Test
    public void create() throws Exception {

        OrderDTO orderDTO = orderService.findOne("1514365025249395434");
        payService.create(orderDTO);
    }

}