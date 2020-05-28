package com.william.mall_portal.controller;

import com.william.mall_portal.service.WilliamLoginServiceImpl;
import com.william.pojo.Result;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.LoginByCaptchaOrPassword;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/18 17:30
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/william-login")
public class WilliamLoginController {

    @Autowired
    private WilliamLoginServiceImpl williamLoginService;

    /**
     * 发送手机验证码
     * @author     xinchuang
     * @param publicReq :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/sendCaptch")
    public Result sendCaptch(@RequestBody PublicReq publicReq){
        return williamLoginService.sendCaptch(publicReq);
    }

    /**
     * token登录
     * @author     xinchuang
     * @param baseRequest :
     * @param token :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/loginByToken")
    public Result loginByToken(@RequestBody BaseRequest baseRequest,@RequestHeader("token")String token){
        return williamLoginService.loginByToken(baseRequest,token);
    }

    /**
     * 手机验证码登录
     * @author     xinchuang
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getLoginByPhoneAndCaptch")
    public Result getLoginByPhoneAndCaptch(@RequestBody LoginByCaptchaOrPassword loginByCaptchaOrPassword){
        return williamLoginService.getLoginByPhoneAndCaptch(loginByCaptchaOrPassword);
    }

    /**
     * 手机号 密码登录
     * @author     xinchuang
     * @param loginByCaptchaOrPassword :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getLoginByPhoneAndPassword")
    public Result getLoginByPhoneAndPassword(@RequestBody LoginByCaptchaOrPassword loginByCaptchaOrPassword){
        return williamLoginService.getLoginByPhoneAndPassword(loginByCaptchaOrPassword);
    }
}
