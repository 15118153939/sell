package com.lv.sell.controller;

import com.lv.sell.config.ProjectUrlConfig;
import com.lv.sell.constant.CookieConstant;
import com.lv.sell.constant.RedisConstant;
import com.lv.sell.dataobject.SellerInfo;
import com.lv.sell.enums.ResultEnum;
import com.lv.sell.service.SellerService;
import com.lv.sell.utils.CookieUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/9 13:45
 * @Description 卖家用户操作相关
 **/
@Controller //涉及到页面跳转，呈现等
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    /**
     * 使用界面登录，
     *
     * @param username
     * @param password
     * @param response
     * @param map
     * @return
     */

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpServletResponse response,
                              Map<String, Object> map) {

        SellerInfo sellerInfo = sellerService.findsellerInfoByUsername(username);

        if (sellerInfo == null) {
//            如果空，跳转到错误界面
            map.put("msg", ResultEnum.LOGIN_FAIL);
            map.put("url", "sell/seller/user/login");
            return new ModelAndView("common/error");
        }

        if (!sellerInfo.getPassword().equals(password)) {

            map.put("msg", ResultEnum.PASSWORD_FAIL);
            map.put("url", "sell/seller/order/list");
            return new ModelAndView("common/error");
        }


//        2：设置token至 redis

        String token = UUID.randomUUID().toString();
//        过期时间
        Integer expire = RedisConstant.EXPIRE;
// 保持格式化的token ,过期时间格式 是秒
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), username, expire, TimeUnit.SECONDS);

//        3:设置 token 至cookie

        //3. 设置token至cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);
//
//        return new ModelAndView(("redirect:/sell/seller/order/list"); //可能也会存在小问题 ，跳转不要用相对地址。容易错
        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/sell/seller/order/list");

    }


    @GetMapping("/login_wechat")
    public ModelAndView login(@RequestParam("openid") String openid,
                              HttpServletResponse response,
                              Map<String, Object> map) {

        SellerInfo sellerInfo = sellerService.findSellerInfoByOpeenId(openid);
//        1:openid去和数据库里面数据匹配
        if (sellerInfo == null) {
//            如果空，跳转到错误界面
            map.put("msg", ResultEnum.LOGIN_FAIL);
            map.put("url", "sell/seller/order/list");
            return new ModelAndView("common/error");
        }


//        2：设置token至 redis

        String token = UUID.randomUUID().toString();
//        过期时间
        Integer expire = RedisConstant.EXPIRE;
// 保持格式化的token ,过期时间格式 是秒
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), openid, expire, TimeUnit.SECONDS);

//        3:设置 token 至cookie

        //3. 设置token至cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);
//
//        return new ModelAndView(("redirect:/sell/seller/order/list"); //可能也会存在小问题 ，跳转不要用相对地址。容易错
        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/sell/seller/order/list");

    }

    /**
     * 登出，退出
     *
     * @param request
     * @param response
     * @param map
     * @return
     */
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {
        //1. 从cookie里查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null) {
            //2. 清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));

            //3. 清除cookie
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }

        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }

}
