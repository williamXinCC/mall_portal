package com.william.mall_portal.service.feginclient;

import com.william.pojo.req.PageConditionReq;
import com.william.pojo.resp.CustomerCouponListResp;
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
    List<CustomerCouponListResp> getCouponByType(@RequestBody PageConditionReq pageConditionReq,@RequestParam("uid") String uid);
}
