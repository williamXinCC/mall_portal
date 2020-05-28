package com.william.mall_portal.service.feginclient;

import com.william.pojo.WilliamCoupon;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.CustomerCouponResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/27 15:31
 * @since Copyright(c) 爱睿智健康科技
 */
@FeignClient("mall-server")
public interface CouponFeginClient {

    @PostMapping(value = "/coupon/getCouponByType")
    List<CustomerCouponResp> getCouponByType(@RequestBody PageConditionReq pageConditionReq, @RequestParam("uid") String uid);

    @PostMapping(value = "/coupon/deleteExpireCoupon")
    void deleteExpireCoupon(@RequestBody BaseRequest baseRequest, @RequestParam("uid") String uid);

    @PostMapping(value = "/coupon/saveCoupon")
    Integer saveCoupon(@RequestBody PublicReq publicReq, @RequestParam("uid") String uid);

    @PostMapping(value = "/coupon/getCouponCenter")
    List<WilliamCoupon> getCouponCenter(@RequestBody BaseRequest baseRequest, @RequestParam("uid") String uid);

    @PostMapping(value = "/coupon/getCouponDetail")
    CustomerCouponResp getCouponDetail(@RequestBody PublicReq publicReq, @RequestParam("uid") String uid);
}
