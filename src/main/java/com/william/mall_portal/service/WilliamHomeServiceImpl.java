package com.william.mall_portal.service;

import com.william.constant.RespCodeAndMsg;
import com.william.mall_portal.service.feginclient.HomeFeginClient;
import com.william.pojo.Result;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.resp.HomePageResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/20 16:17
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamHomeServiceImpl {

    @Autowired
    private HomeFeginClient homeFeginClient;

    public Result getHomePage(BaseRequest baseRequest) {
        HomePageResp homePageResp = homeFeginClient.getHomePage(baseRequest);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,homePageResp);
    }
}
