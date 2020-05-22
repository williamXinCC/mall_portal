package com.william.mall_portal.controller;

import com.william.mall_portal.service.WilliamCustomerServiceImpl;
import com.william.pojo.Result;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.UpdateCustomerReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/18 16:53
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/william-customer")
public class WilliamCustomerController {

    @Autowired
    private WilliamCustomerServiceImpl williamCustomerServiceImpl;

    /**
     * 修改个人信息
     * @author     xinchuang
     * @param updateCustomerReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/updateCustomerInfo")
    public Result updateCustomerInfo(@RequestBody UpdateCustomerReq updateCustomerReq,@RequestHeader("uid")String uid){
        return williamCustomerServiceImpl.updateCustomerInfo(updateCustomerReq,uid);
    }

    /**
     * 个人信息
     * @author     xinchuang
     * @param baseRequest :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getCustomerInfo")
    public Result getCustomerInfo(@RequestBody BaseRequest baseRequest, @RequestHeader("uid")String uid){
       return williamCustomerServiceImpl.getCustomerInfo(baseRequest,uid);
    }
}
