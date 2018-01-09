package com.lv.sell.service;

import com.lv.sell.dataobject.SellerInfo;
import org.springframework.stereotype.Service;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/9 13:22
 * @Description
 **/

@Service
public interface SellerService {

    SellerInfo findSellerInfoByOpeenId(String opeinId);

    SellerInfo findsellerInfoByUsername(String uesrname);
}
