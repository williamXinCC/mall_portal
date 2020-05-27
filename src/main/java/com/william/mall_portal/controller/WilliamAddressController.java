package com.william.mall_portal.controller;

import com.william.mall_portal.service.WilliamAddressServiceImpl;
import com.william.pojo.Result;
import com.william.pojo.req.AddressReq;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 地址
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/26 11:33
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/william-address")
public class WilliamAddressController {

    @Autowired
    private WilliamAddressServiceImpl williamAddressService;

    /**
     * 设置默认地址
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/updateDefaultAddress")
    public Result updateDefaultAddress(@RequestBody PublicReq publicReq,@RequestHeader("uid")String uid){
        return williamAddressService.updateDefaultAddress(publicReq,uid);
    }

    /**
     * 默认收货地址
     * @author     xinchuang
     * @param baseRequest :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getDefaultAddress")
    public Result getDefaultAddress(@RequestBody BaseRequest baseRequest,@RequestHeader("uid")String uid){
        return williamAddressService.getDefaultAddress(baseRequest,uid);
    }

    /**
     * 删除地址
     * @author     xinchuang
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/deleteAddress")
    public Result deleteAddress(@RequestBody PublicReq publicReq, @RequestHeader(value = "uid")String uid){
       return williamAddressService.deleteAddress(publicReq,uid);
    }

    /**
     * 修改地址
     * @author     xinchuang
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/updateAddress")
    public Result updateAddress(@RequestBody AddressReq addressReq, @RequestHeader(value = "uid")String uid){
        return williamAddressService.updateAddress(addressReq,uid);
    }

    /**
     * 添加新地址
     * @author     xinchuang
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/saveAddress")
    public Result saveAddress(@RequestBody AddressReq addressReq, @RequestHeader(value = "uid")String uid){
        return williamAddressService.saveAddress(addressReq,uid);
    }


    /**
     * 地址管理
     * @author     xinchuang
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getCustomerAddressList")
    public Result getCustomerAddressList(@RequestBody BaseRequest baseRequest, @RequestHeader(value = "uid")String uid){
        return williamAddressService.getCustomerAddressList(baseRequest,uid);
    }
}
