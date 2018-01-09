package com.lv.sell.service.impl;

import com.lv.sell.dataobject.SellerInfo;
import com.lv.sell.repository.SellerInfoRepository;
import com.lv.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/9 13:23
 * @Description
 **/
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerInfoRepository repository;
    @Override
    public SellerInfo findSellerInfoByOpeenId(String opeinId) {
        return repository.findByOpenid(opeinId);
    }

    @Override
    public SellerInfo findsellerInfoByUsername(String username) {
        return repository.findByUsername(username);
    }
}
