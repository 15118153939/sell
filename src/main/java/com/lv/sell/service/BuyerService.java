package com.lv.sell.service;

import com.lv.sell.dto.OrderDTO;

/**
 * 买家
 *
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/27 19:03
 * @Description
 **/
public interface BuyerService {
    //    查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);


    //    取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
