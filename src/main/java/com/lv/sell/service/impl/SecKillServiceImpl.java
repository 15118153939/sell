package com.lv.sell.service.impl;

import com.lv.sell.exception.SellException;
import com.lv.sell.service.SecKillService;
import com.lv.sell.utils.KeyUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/10 9:07
 * @Description
 **/
@Service
public class SecKillServiceImpl implements SecKillService {

    private static final int TIMEOUT = 10 * 100;//超时时间 10s

    //    三个map模拟三个表
    static Map<String, Integer> products;
    static Map<String, Integer> stock;
    static Map<String, String> orders;

    static {
        /**
         * 模拟多个表，商品信息表，库存表，秒杀成功订单表
         */

        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();

        products.put("123456", 100000);
        stock.put("123456", 100000);
    }



    public String queryMap(String productId) {
        return "国庆活动，皮蛋粥特价，限量份"
                + products.get(productId)
                + " 还剩：" + stock.get(productId) + " 份"
                + " 该商品成功下单用户数目："
                + orders.size() + " 人";
    }

    @Override
    public synchronized void  orderProductMockDiffUser(String productId) {

//        查询该商品库存，为0活动结束

        int stockNum = stock.get(productId);
        if (stockNum == 0) {
            throw new SellException(100, "活动结束了");
        } else {
//          2  下单
            orders.put(KeyUtil.genUniqueKey(), productId);
//            3:减少库存
            stockNum = stockNum - 1;
            try {
//                有一些io操作等，所以休眠一些时间
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stock.put(productId, stockNum);
        }

    }

    @Override
    public String querySecKillProductInfo(String productId)
    {
        return this.queryMap(productId);
    }
}
