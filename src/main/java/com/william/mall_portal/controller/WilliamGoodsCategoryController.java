package com.william.mall_portal.controller;

import com.william.mall_portal.service.WilliamGoodsCategoryServiceImpl;
import com.william.pojo.Result;
import com.william.pojo.req.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 商品分类
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/21 11:24
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/william-goods-category")
public class WilliamGoodsCategoryController {

    @Autowired
    private WilliamGoodsCategoryServiceImpl williamGoodsCategoryService;

    @PostMapping(value = "/getGoodsCategoryTreeList")
    public Result getGoodsCategoryTreeList(@RequestBody BaseRequest baseRequest, @RequestParam(value = "uid",required = false)String uid){
        return williamGoodsCategoryService.getGoodsCategoryTreeList(baseRequest,uid);
    }
}
