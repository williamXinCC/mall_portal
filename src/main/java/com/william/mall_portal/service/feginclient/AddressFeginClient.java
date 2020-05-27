package com.william.mall_portal.service.feginclient;

import com.william.pojo.WilliamCustomerLocation;
import com.william.pojo.req.AddressReq;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PublicReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/26 11:46
 * @since Copyright(c) 爱睿智健康科技
 */
@FeignClient("mall-server")
public interface AddressFeginClient {

    // 地址列表
    @PostMapping(value = "/address/getCustomerAddressList")
    List<WilliamCustomerLocation> getCustomerAddressList(@RequestBody BaseRequest baseRequest,@RequestParam("uid") String uid);

    @PostMapping(value = "/address/deleteAddress")
    void deleteAddress(@RequestBody PublicReq publicReq,@RequestParam("uid") String uid);

    @PostMapping(value = "/address/updateAddress")
    void updateAddress(@RequestBody AddressReq addressReq,@RequestParam("uid") String uid);

    @PostMapping(value = "/address/saveAddress")
    void saveAddress(@RequestBody AddressReq addressReq,@RequestParam("uid") String uid);

    @PostMapping(value = "/address/getDefaultAddress")
    WilliamCustomerLocation getDefaultAddress(@RequestBody BaseRequest baseRequest,@RequestParam("uid") String uid);

    @PostMapping(value = "/address/updateDefaultAddress")
    void updateDefaultAddress(@RequestBody PublicReq publicReq,@RequestParam("uid") String uid);
}
