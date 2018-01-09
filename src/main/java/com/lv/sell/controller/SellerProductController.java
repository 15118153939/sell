package com.lv.sell.controller;

import com.lv.sell.dataobject.ProductCategory;
import com.lv.sell.dataobject.ProductInfo;
import com.lv.sell.form.ProductForm;
import com.lv.sell.service.CategoryService;
import com.lv.sell.service.ProductService;
import com.lv.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 卖家端商品
 *
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/6 13:11
 * @Description
 **/
@Controller
@Slf4j
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * @param page 第几页
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "0") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {


        PageRequest request = new PageRequest(page, size);

        Page<ProductInfo> productInfoPage = productService.findAll(request);

        map.put("productInfoPage", productInfoPage);
        map.put("size", size);
        map.put("currentPage", page);


        return new ModelAndView("product/list", map);

    }

    /**
     * 商品上架
     *
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId, Map<String, Object> map
    ) {
        try {
            productService.onSale(productId);
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);

        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    @RequestMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId, Map<String, Object> map) {

        try {
            productService.offSale(productId);
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);

        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);

    }

    /**
     * 展示
     * @param productId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId, Map<String, Object> map) {

        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }
//        查询所有类目
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("product/index", map);

    }

    /**
     * 新增/修改
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
//    @CacheEvict(cacheNames = "product")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }

        ProductInfo productInfo = new ProductInfo();
        try {
//如果priductId为空，则说明是新增
            if (!StringUtils.isEmpty(form.getProductId())) {
//                更新
                productInfo = productService.findOne(form.getProductId());
            } else {
//                新增获取一个随机id
                form.setProductId(KeyUtil.genUniqueKey());

            }
//copy属性
            BeanUtils.copyProperties(form, productInfo);
            productService.save(productInfo);

        } catch (BeansException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
