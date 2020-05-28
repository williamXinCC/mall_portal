package com.william.mall_portal.controller;

import com.william.mall_portal.service.WilliamCouponServiceImpl;
import com.william.pojo.Result;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 优惠券
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/27 10:46
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/william-coupon")
public class WilliamCouponController {

    @Autowired
    private WilliamCouponServiceImpl williamCouponService;

    /**
     * 删除已过期优惠券
     * @author     xinchuang
     * @param baseRequest :
     * @param uid :
     * @return : void
     */
    @PostMapping(value = "/deleteExpireCoupon")
    public Result deleteExpireCoupon(@RequestBody BaseRequest baseRequest, @RequestHeader("uid")String uid){
        return williamCouponService.deleteExpireCoupon(baseRequest,uid);
    }

    /**
     * 领取 保存我的优惠券
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/saveCoupon")
    public Result saveCoupon(@RequestBody PublicReq publicReq, @RequestHeader("uid")String uid){
        return williamCouponService.saveCoupon(publicReq,uid);
    }

    /**
     * 领券中心列表
     * @author     xinchuang
     * @param baseRequest :
     * @param uid :
     * @return : java.util.List<com.william.pojo.resp.CustomerCouponResp>
     */
    @PostMapping(value = "/getCouponCenter")
    public Result getCouponCenter(@RequestBody BaseRequest baseRequest, @RequestHeader("uid")String uid){
        return williamCouponService.getCouponCenter(baseRequest,uid);
    }

    /**
     * 优惠券详情
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.resp.CustomerCouponListResp
     */
    @PostMapping(value = "/getCouponDetail")
    public Result getCouponDetail(@RequestBody PublicReq publicReq, @RequestHeader("uid")String uid){
        return williamCouponService.getCouponDetail(publicReq,uid);
    }

    /**
     * 我的优惠券
     * @author     xinchuang
     * @param pageConditionReq:
     * @param uid :
     * @return : java.util.List<com.william.pojo.resp.CustomerCouponListResp>
     */
    @PostMapping(value = "/getCouponByType")
    public Result getCouponByType(@RequestBody PageConditionReq pageConditionReq, @RequestHeader("uid")String uid){
        return williamCouponService.getCouponByType(pageConditionReq,uid);
    }
}
