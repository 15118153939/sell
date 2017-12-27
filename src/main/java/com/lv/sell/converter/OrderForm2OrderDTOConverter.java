package com.lv.sell.converter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.lv.sell.dataobject.OrderDetail;
import com.lv.sell.dto.OrderDTO;
import com.lv.sell.enums.ResultEnum;
import com.lv.sell.exception.SellException;
import com.lv.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/27 15:42
 * @Description
 **/
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {

        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerAddress(orderForm.getAddress());
//字符，json 转对象，用 gson google出的一个工具

//        转换可能会出错


        List<OrderDetail> orderDetailList = new ArrayList<>();


        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());

        } catch (JsonSyntaxException e) {
            log.error("【对象转换】错误，str={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }



        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
