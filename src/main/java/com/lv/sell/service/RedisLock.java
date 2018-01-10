package com.lv.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/10 11:00
 * @Description
 **/
@Slf4j
@Component
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * 加锁
     *
     * @param key
     * @param value 当前时间+超时时间  时间戳
     * @return
     */
    public boolean lock(String key, String value) {

//        如果可以成功设置
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }
//如果没有如下代码，其他代码如果抛异常解锁失败，则容易出现死锁的情况。

        String currentValue = redisTemplate.opsForValue().get(key);
//        如果锁过期
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {

//            获取上一个锁的时间
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);

//
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }

        }

        return false;


    }

    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e) {
            log.error("【redis分布式锁】解锁异常, {}", e);
        }
    }
}
