package com.lv.sell.repository;

import com.lv.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 18:06
 * @Description
 **/
@Repository
public interface OrderMasterRepository extends JpaRepository <OrderMaster, String> {

    /***
     * 根据openid 分页查询，
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid,Pageable pageable);
}
