package com.lv.sell.service;

import com.lv.sell.dto.OrderDTO;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/9 17:49
 * @Description
 **/
public interface PushMessageService {
    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
