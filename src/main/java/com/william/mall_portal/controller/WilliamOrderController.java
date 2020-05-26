package com.william.mall_portal.controller;

import com.william.mall_portal.service.WilliamOrderServiceImpl;
import com.william.pojo.Result;
import com.william.pojo.WilliamOrder;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单表
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/25 12:02
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/william-order")
public class WilliamOrderController {

    @Autowired
    private WilliamOrderServiceImpl williamOrderService;

    /**
     * 查订单详情
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getOrderDetail")
    public Result getOrderDetail(@RequestBody PublicReq publicReq,@RequestHeader(value = "uid")String uid){
        return williamOrderService.getOrderDetail(publicReq,uid);
    }

    /**
     * 状态查询我的订单 1 待付款 2 待发货 3 待收货
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamOrder>
     */
    @PostMapping(value = "/getOrderListByStatus")
    public Result getOrderListByStatus(@RequestBody PageConditionReq pageConditionReq, @RequestHeader("uid")String uid){
        return williamOrderService.getOrderListByStatus(pageConditionReq,uid);
    }
}
