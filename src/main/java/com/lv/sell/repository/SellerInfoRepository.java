package com.lv.sell.repository;

import com.lv.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/9 13:04
 * @Description
 **/
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String>{
    SellerInfo findByOpenid(String openid);
    SellerInfo findByUsername(String username);
}
