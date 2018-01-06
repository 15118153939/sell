package com.lv.sell.service.impl;

import com.lv.sell.dto.OrderDTO;
import com.lv.sell.enums.ResultEnum;
import com.lv.sell.exception.SellException;
import com.lv.sell.service.BuyerService;
import com.lv.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/27 19:06
 * @Description
 **/
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;
    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {

        return checkOrderOwner(openid,orderId);
    }

    private OrderDTO checkOrderOwner(String openid,String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);

        if (orderDTO == null) {
            return null;
        }
//        判断是否是自己的订单
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(orderId)){
            log.error("【查询订单】订单的openid不一致，openid={},orderDTO={}",orderId,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWENR_ERROR);
        }
        return orderDTO;
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO= checkOrderOwner(openid,orderId);

        if (orderDTO == null) {
            log.error("[取消订单]查不到该订单，orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }
}
