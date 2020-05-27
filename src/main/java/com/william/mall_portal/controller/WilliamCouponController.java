package com.william.mall_portal.controller;

import com.william.mall_portal.service.WilliamCouponServiceImpl;
import com.william.pojo.Result;
import com.william.pojo.req.PageConditionReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/27 10:46
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/william-coupon")
public class WilliamCouponController {

    @Autowired
    private WilliamCouponServiceImpl williamCouponServiceImpl;

    /**
     * 我的优惠券
     * @author     xinchuang
     * @param pageConditionReq:
     * @param uid :
     * @return : java.util.List<com.william.pojo.resp.CustomerCouponListResp>
     */
    @PostMapping(value = "/getCouponByType")
    public Result getCouponByType(@RequestBody PageConditionReq pageConditionReq, @RequestHeader("uid")String uid){
        return williamCouponServiceImpl.getCouponByType(pageConditionReq,uid);
    }
}
