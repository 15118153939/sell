package com.lv.sell.service;

import com.lv.sell.dataobject.OrderMaster;
import com.lv.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 19:42
 * @Description
 **/
public interface OrderService {
    /***
     * 创建订单
     */
    OrderDTO create(OrderDTO orderDTO);

    /***
     * 查询单个
     */

    OrderDTO findOne(String orderId);

    /***
     * 查询列表
     */
Page<OrderDTO> findList(String buyerOpenId,Pageable pageable);

    /***
     * 取消订单
     */

    OrderDTO cancel(OrderDTO orderDTO);


    /**
     * 完结订单
     */

    OrderDTO finish(OrderDTO orderDTO);

    /***
     * 支付订单
     */
    OrderDTO paid(OrderDTO orderDTO);
}
