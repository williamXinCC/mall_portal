package com.william.mall_portal.service;

import com.william.constant.RespCodeAndMsg;
import com.william.mall_portal.service.feginclient.CouponFeginClient;
import com.william.pojo.Result;
import com.william.pojo.WilliamCoupon;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.CustomerCouponResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/27 14:00
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamCouponServiceImpl {

    @Autowired
    private CouponFeginClient couponFeginClient;

    public Result getCouponByType(PageConditionReq pageConditionReq, String uid) {
        List<CustomerCouponResp> couponListResps = couponFeginClient.getCouponByType(pageConditionReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,couponListResps);
    }

    public Result deleteExpireCoupon(BaseRequest baseRequest, String uid) {
        couponFeginClient.deleteExpireCoupon(baseRequest,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS);
    }

    public Result saveCoupon(PublicReq publicReq, String uid) {
        Integer result = couponFeginClient.saveCoupon(publicReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,result);
    }

    public Result getCouponCenter(BaseRequest baseRequest, String uid) {
        List<WilliamCoupon> williamCouponList = couponFeginClient.getCouponCenter(baseRequest,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,williamCouponList);
    }

    public Result getCouponDetail(PublicReq publicReq, String uid) {
        CustomerCouponResp customerCouponResp = couponFeginClient.getCouponDetail(publicReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,customerCouponResp);
    }
}
