package com.william.mall_portal.controller;

import com.william.mall_portal.service.WilliamGoodsServiceImpl;
import com.william.pojo.Result;
import com.william.pojo.WilliamGoods;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PageReq;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/19 15:39
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/william-goods")
public class WilliamGoodsController {

    @Autowired
    private WilliamGoodsServiceImpl goodsService;

    /**
     * 热门商品
     * @author     xinchuang
     * @param pageReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getHotGoodsByPage")
    public Result getHotGoodsByPage(@RequestBody PageReq pageReq, @RequestHeader(value = "uid",required = false)String uid){
        return goodsService.getHotGoodsByPage(pageReq,uid);
    }

    /**
     * 推荐商品  condition为分类 分页
     * @author     xinchuang
     * @param pageReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getRecommendGoodsByPage")
    public Result getRecommendGoodsByPage(@RequestBody PageReq pageReq, @RequestHeader(value = "uid",required = false)String uid){
        return goodsService.getRecommendGoodsByPage(pageReq,uid);
    }

    /**
     * 新品上市  condition为分类 分页
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getNewGoodsByPageCondition")
    public Result getNewGoodsPageCondition(@RequestBody PageConditionReq pageConditionReq,@RequestHeader(value = "uid",required = false)String uid){
        return goodsService.getNewGoodsPageCondition(pageConditionReq,uid);
    }


    /**
     * 分类商品列表  分页
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamGoods>
     */
    @PostMapping(value = "/getGoodsListByCategory")
    public Result getGoodsListByCategory(@RequestBody PageConditionReq pageConditionReq, @RequestHeader(value = "uid",required = false)String uid){
        return goodsService.getGoodsListByCategory(pageConditionReq,uid);
    }

    /**
     * 商品详情页
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getGoodsInfoPage")
    public Result getGoodsInfoPage(@RequestBody PublicReq publicReq, @RequestHeader(value = "uid",required = false)String uid){
        return goodsService.getGoodsInfoPage(publicReq,uid);
    }
}
