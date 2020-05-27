package com.william.mall_portal.service;

import com.william.constant.RespCodeAndMsg;
import com.william.mall_portal.service.feginclient.CouponFeginClient;
import com.william.pojo.Result;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.resp.CustomerCouponListResp;
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
    private CouponFeginClient couponFeginClientl;

    public Result getCouponByType(PageConditionReq pageConditionReq, String uid) {
        List<CustomerCouponListResp> couponListResps = couponFeginClientl.getCouponByType(pageConditionReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,couponListResps);
    }
}
