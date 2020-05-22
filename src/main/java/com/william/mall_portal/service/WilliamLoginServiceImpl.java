package com.william.mall_portal.service;

import com.william.constant.RespCodeAndMsg;
import com.william.mall_portal.service.feginclient.LoginFeginClient;
import com.william.pojo.Result;
import com.william.pojo.req.LoginByCaptchaOrPassword;
import com.william.pojo.resp.LoginResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/18 17:36
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamLoginServiceImpl {

    @Autowired
    private LoginFeginClient loginFeginClient;

    public Result getLoginByPhoneAndCaptch(LoginByCaptchaOrPassword loginByCaptchaOrPassword) {
        LoginResp loginResp = loginFeginClient.getLoginByPhoneAndCaptch(loginByCaptchaOrPassword);
        if(Objects.nonNull(loginResp)){
            return Result.getResult(RespCodeAndMsg.LOGIN_SUCCESS,loginResp);
        }
        return Result.getResult(RespCodeAndMsg.LOGIN_ERROR);
    }

    public Result getLoginByPhoneAndPassword(LoginByCaptchaOrPassword loginByCaptchaOrPassword) {
        LoginResp loginResp = loginFeginClient.getLoginByPhoneAndPassword(loginByCaptchaOrPassword);
        if(Objects.nonNull(loginResp)){
            return Result.getResult(RespCodeAndMsg.LOGIN_SUCCESS,loginResp);
        }
        return Result.getResult(RespCodeAndMsg.LOGIN_ERROR_NON_PASS);
    }
}
