package com.lv.sell.repository;

import com.lv.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 18:43
 * @Description
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String>{
    List<OrderDetail> findByOrderId(String orderId);
}
