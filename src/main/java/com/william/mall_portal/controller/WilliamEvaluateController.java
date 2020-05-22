package com.william.mall_portal.controller;

import com.william.mall_portal.service.WilliamEvaluateServiceImpl;
import com.william.pojo.Result;
import com.william.pojo.req.EvaluateListReq;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 评价
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/19 10:29
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/william-evaluate")
public class WilliamEvaluateController {

    @Autowired
    private WilliamEvaluateServiceImpl williamEvaluateService;

    /**
     * 商品评价分类 统计
     * @author     xinchuang
     * @param publicReq :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getCountByType")
    public Result getCountByType(@RequestBody PublicReq publicReq){
       return williamEvaluateService.getCountByType(publicReq);
    }

    /**
     * 商品评价 分类 分页
     * @author     xinchuang
     * @param evaluateListReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamEvaluate>
     */
    @PostMapping(value = "/getEvaluateListByGoodsIdAndType")
    public Result getEvaluateListByGoodsIdAndType(@RequestBody EvaluateListReq evaluateListReq, @RequestHeader("uid")String uid){
        return williamEvaluateService.getEvaluateListByGoodsIdAndType(evaluateListReq,uid);
    }
}
