package com.william.mall_portal.service;

import com.william.constant.RespCodeAndMsg;
import com.william.mall_portal.redis.RedisService;
import com.william.mall_portal.service.feginclient.CustomerFeginClient;
import com.william.pojo.Result;
import com.william.pojo.WilliamCustomer;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.UpdateCustomerReq;
import com.william.pojo.req.UpdatePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/18 16:56
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamCustomerServiceImpl {

    @Autowired
    private CustomerFeginClient customerFeginClient;

    @Autowired
    private RedisService redisService;

    /**
     * 客户详情
     * @author     xinchuang
     * @param baseRequest :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    public Result getCustomerInfo(BaseRequest baseRequest, String uid){
        WilliamCustomer customerInfo = customerFeginClient.getCustomerInfo(baseRequest, uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,customerInfo);
    }

    /**
     * 修改个人信息
     * @author     xinchuang
     * @param updateCustomerReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    public Result updateCustomerInfo(UpdateCustomerReq updateCustomerReq, String uid) {
       return customerFeginClient.updateCustomerInfo(updateCustomerReq,uid);
    }

    public Result updatePassword(UpdatePassword updatePassword, String uid) {
        String captch = redisService.getStr(updatePassword.getPhone().concat("captch"));
        if(Objects.equals(captch,updatePassword.getCaptch())){
            customerFeginClient.updatePassword(updatePassword,uid);
            return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS);
        }
        return Result.getResult(RespCodeAndMsg.UPDATE_PASSWORD_FAILED);
    }
}
