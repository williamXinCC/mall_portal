package com.william.mall_portal.service;

import com.william.constant.RespCodeAndMsg;
import com.william.mall_portal.service.feginclient.AddressFeginClient;
import com.william.pojo.Result;
import com.william.pojo.WilliamCustomerLocation;
import com.william.pojo.req.AddressReq;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/26 11:42
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamAddressServiceImpl {

    @Autowired
    private AddressFeginClient addressFeginClient;

    public Result getCustomerAddressList(BaseRequest baseRequest, String uid) {
        List<WilliamCustomerLocation> locationList = addressFeginClient.getCustomerAddressList(baseRequest,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,locationList);
    }

    public Result deleteAddress(PublicReq publicReq, String uid) {
        addressFeginClient.deleteAddress(publicReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS);
    }

    public Result updateAddress(AddressReq addressReq, String uid) {
        addressFeginClient.updateAddress(addressReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS);
    }

    public Result saveAddress(AddressReq addressReq, String uid) {
        addressFeginClient.saveAddress(addressReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS);
    }

    public Result getDefaultAddress(BaseRequest baseRequest, String uid) {
        WilliamCustomerLocation williamCustomerLocation = addressFeginClient.getDefaultAddress(baseRequest,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,williamCustomerLocation);
    }

    public Result updateDefaultAddress(PublicReq publicReq, String uid) {
        addressFeginClient.updateDefaultAddress(publicReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS);
    }
}
