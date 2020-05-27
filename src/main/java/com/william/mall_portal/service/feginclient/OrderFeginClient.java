package com.william.mall_portal.service.feginclient;

import com.william.pojo.WilliamOrder;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.OrderDetailResp;
import com.william.pojo.resp.OrderResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 订单
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/25 14:27
 * @since Copyright(c) 爱睿智健康科技
 */
@FeignClient("mall-server")
public interface OrderFeginClient {

    /**
     * 状态查询我的订单 1 待付款 2 待发货 3 待收货
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamOrder>
     */
    @PostMapping(value = "/order/getOrderListByStatus")
    List<OrderResp> getOrderListByStatus(@RequestBody PageConditionReq pageConditionReq, @RequestParam("uid") String uid);

    // 订单详情
    @PostMapping(value = "/order/getOrderDetail")
    OrderDetailResp getOrderDetail(@RequestBody PublicReq publicReq,@RequestParam("uid") String uid);

    // 删除订单
    @PostMapping(value = "/order/deleteOrder")
    void deleteOrder(@RequestBody PublicReq publicReq,@RequestParam("uid") String uid);
}
