package com.william.mall_portal.service.feginclient;

import com.william.pojo.Result;
import com.william.pojo.WilliamCustomer;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.UpdateCustomerReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/18 16:59
 * @since Copyright(c) 爱睿智健康科技
 */
@FeignClient("mall-server")
public interface CustomerFeginClient {

    @PostMapping(value = "/customer/getCustomerInfo")
    WilliamCustomer getCustomerInfo(@RequestBody BaseRequest baseRequest,@RequestParam("uid") String uid);

    @PostMapping(value = "/customer/updateCustomerInfo")
    Result updateCustomerInfo(@RequestBody UpdateCustomerReq updateCustomerReq,@RequestParam("uid") String uid);
}
