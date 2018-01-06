package com.lv.sell.service.impl;

import com.lv.sell.dataobject.OrderDetail;
import com.lv.sell.dto.OrderDTO;
import com.lv.sell.enums.OrderStatusEnum;
import com.lv.sell.enums.PayStatusEnum;
import com.lv.sell.repository.OrderDetailRepository;
import com.lv.sell.repository.OrderMasterRepository;
import com.lv.sell.service.OrderService;
import com.lv.sell.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.expression.spel.ast.OpOr;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 21:17
 * @Description
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    private final String BUYER_OPENID = "110010";
    private final String ORDER_ID = "1514258346789966646";

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderService orderService;


    @Test
    public void create() throws Exception {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("王晓米");
        orderDTO.setBuyerAddress("XXXOOOOXXX");
        orderDTO.setBuyerPhone("15118153939");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

//        购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("1234569");
        orderDetail.setProductQuantity(5);

        orderDetailList.add(orderDetail);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);

        log.info("[创建订单：]result={}", result);

    }

    @Test
    public void findOne() throws Exception {

        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("[查询单个订单]result={}", result);
    }

    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(0, 5);

        Page<OrderDTO> page = orderService.findList(BUYER_OPENID, request);

        System.out.println(page.toString());
        Assert.assertNotEquals(0, page.getTotalElements());
        System.out.println(page);
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);

        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);

        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());

    }

    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);

        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }

    @Test
    public void findAllTest() throws Exception {

        PageRequest request = new PageRequest(0, 5);

        Page<OrderDTO> page = orderService.findList(BUYER_OPENID, request);

        System.out.println(page.toString());
        Assert.assertNotEquals(0, page.getTotalElements());
//        写的统一一点
        Assert.assertTrue("查询所有的订单列表",page.getTotalElements()>0);
        System.out.println(page);
    }

}