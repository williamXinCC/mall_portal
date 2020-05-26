package com.william.mall_portal.service;

import com.william.constant.RespCodeAndMsg;
import com.william.mall_portal.service.feginclient.OrderFeginClient;
import com.william.pojo.Result;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.OrderDetailResp;
import com.william.pojo.resp.OrderResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/25 14:25
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamOrderServiceImpl {

    @Autowired
    private OrderFeginClient orderFeginClient;

    /**
     * 状态查询我的订单 1 待付款 2 待发货 3 待收货
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamOrder>
     */
    public Result getOrderListByStatus(PageConditionReq pageConditionReq, String uid) {
        List<OrderResp> orderList = orderFeginClient.getOrderListByStatus(pageConditionReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,orderList);
    }

    /**
     * 订单详情
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    public Result getOrderDetail(PublicReq publicReq, String uid) {
        OrderDetailResp orderDetailResp = orderFeginClient.getOrderDetail(publicReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,orderDetailResp);
    }
}
