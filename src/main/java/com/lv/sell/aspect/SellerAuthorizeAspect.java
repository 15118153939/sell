package com.lv.sell.aspect;

import com.lv.sell.constant.CookieConstant;
import com.lv.sell.constant.RedisConstant;
import com.lv.sell.exception.SellerAuthorizeException;
import com.lv.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/9 15:13
 * @Description AOP实现身份验证
 **/
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * 切入点：所有卖家Seller开头的的操作
     */
    @Pointcut("execution(public * com.lv.sell.controller.Seller*.*(..))" +
            "&& !execution(public * com.lv.sell.controller.SellerUserController.*(..))")
    public void verify() {
    }

    ;


    /**
     * 在切入点之前：
     */
    @Before("verify()")
    public void doVerify() {
//        1:获取 HttpServletRequest
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

//        2:查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
//如果cookie没有值，则没有登录
        if (cookie == null) {
            log.warn("[登录校验]Cookie中查询不到token");
            throw new SellerAuthorizeException();
        }

        //去redis里查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("【登录校验】Redis中查不到token");
            throw new SellerAuthorizeException();
        }

    }


}
