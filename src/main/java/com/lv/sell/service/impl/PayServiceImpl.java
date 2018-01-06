package com.lv.sell.service.impl;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.lv.sell.dto.OrderDTO;
import com.lv.sell.enums.ResultEnum;
import com.lv.sell.exception.SellException;
import com.lv.sell.service.OrderService;
import com.lv.sell.service.PayService;
import com.lv.sell.utils.JsonUtil;
import com.lv.sell.utils.MathUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/28 20:52
 * @Description
 **/
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    public static final String order_name = "微信点餐订单";



    private BestPayServiceImpl bestPayService = new BestPayServiceImpl();

    @Autowired
    private OrderService orderService;

    @Override
    public PayResponse create(OrderDTO orderDTO) {

        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        PayResponse payResponse = bestPayService.pay(payRequest);

        log.info("[微信支付] request={}", JsonUtil.toJson(bestPayService.pay(payRequest)));
        log.info("[微信支付] response={} ",JsonUtil.toJson( payResponse));
        return payResponse;
    }

    @Override
    public PayResponse notify(String notifyData) {
        //1. 验证签名
        //2. 支付的状态
        //3. 支付金额
        //4. 支付人(下单人 == 支付人)
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("【微信支付】异步通知, payResponse={}", JsonUtil.toJson(payResponse));

        //查询订单
        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());

        //判断订单是否存在
        if (orderDTO == null) {
            log.error("【微信支付】异步通知, 订单不存在, orderId={}", payResponse.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //判断金额是否一致(0.10   0.1)
        if (!MathUtil.equals(payResponse.getOrderAmount(), orderDTO.getOrderAmount().doubleValue())) {
            log.error("【微信支付】异步通知, 订单金额不一致, orderId={}, 微信通知金额={}, 系统金额={}",
                    payResponse.getOrderId(),
                    payResponse.getOrderAmount(),
                    orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
        }

        //修改订单的支付状态
        orderService.paid(orderDTO);

        return payResponse;
    }

    @Override
    public RefundResponse refund(OrderDTO orderDTO) {
        return null;
    }
}
