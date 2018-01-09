package com.lv.sell.controller;

import com.lv.sell.dataobject.ProductCategory;
import com.lv.sell.dataobject.ProductInfo;
import com.lv.sell.service.CategoryService;
import com.lv.sell.service.ProductService;
import com.lv.sell.vo.ProductInfoVO;
import com.lv.sell.vo.ProductVO;
import com.lv.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lv.sell.utils.ResultVOUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/22 10:29
 * @Description 买家商品
 **/
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
//        1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findAll();
//        2.查询类目（一次性查询）
//        List<Integer>  categoryTypeList = new ArrayList<>();
//      传统方法
        /*
        for (ProductInfo productInfo:productInfoList){
        categoryTypeList.add(productInfo.getCategoryType());
        }*/


//        精简方式（java8,maboda表达式）
        List<Integer> categoryTypeList = productInfoList.stream().
                map(e -> e.getCategoryType()).
                collect(Collectors.toList());

        List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(categoryTypeList);



        //        3：数据拼装
List<ProductVO> productVOList = new ArrayList<>();
//        遍历类目
        for (ProductCategory productCategory:productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());


            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo :productInfoList){
//                spring
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);




    }
}
