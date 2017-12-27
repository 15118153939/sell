package com.lv.sell.converter;

import com.lv.sell.dataobject.OrderMaster;
import com.lv.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/26 19:46
 * @Description
 * 转换器
 **/
public class OrderMaster2OrderDTOConverter {
    private static OrderDTO convert(OrderMaster orderMaster){

        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    /***
     *
     * @param orderMasterList
     * @return
     */
    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
      return   orderMasterList.stream().map(e -> convert(e)
        ).collect(Collectors.toList());

    }
}
