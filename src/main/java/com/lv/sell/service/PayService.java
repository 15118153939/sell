package com.lv.sell.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.lv.sell.dto.OrderDTO;
import org.springframework.stereotype.Service;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/28 20:49
 * @Description
 **/
@Service
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
