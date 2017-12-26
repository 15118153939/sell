package com.lv.sell.service.impl;

import com.lv.sell.dataobject.OrderDetail;
import com.lv.sell.dataobject.OrderMaster;
import com.lv.sell.dataobject.ProductInfo;
import com.lv.sell.dto.CartDTO;
import com.lv.sell.dto.OrderDTO;
import com.lv.sell.enums.OrderStatusEnum;
import com.lv.sell.enums.PayStatusEnum;
import com.lv.sell.enums.ResultEnum;
import com.lv.sell.exception.SellException;
import com.lv.sell.repository.OrderDetailRepository;
import com.lv.sell.repository.OrderMasterRepository;
import com.lv.sell.service.OrderService;
import com.lv.sell.service.ProductService;
import com.lv.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 19:54
 * @Description
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;
    /***
     * 创建订单：
     *
     * @param orderDTO
     * @return
     */
    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
//        創建ID
        String orderId = KeyUtil.genUniqueKey();

        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

//         1.查询商品（数量，价格）
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());

            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

//        2.计算订单总价
//            先计算一件商品总价。然后多种总价
            orderAmount = productInfo.getProductPrice().
                    multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);

//            订单详情入库
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
//            copy 商品小图片
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);
        }

//        3写入订单数据库（OrderMaster 和OrderDetail）

        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);

        orderMaster.setOrderId(orderId);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderAmount(orderAmount);

        orderMasterRepository.save(orderMaster);

//        4:扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());



        productService.decreaseStock(cartDTOList);


        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
