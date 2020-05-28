package com.william.mall_portal.service.feginclient;

import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.LoginByCaptchaOrPassword;
import com.william.pojo.resp.LoginResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/18 17:39
 * @since Copyright(c) 爱睿智健康科技
 */
@FeignClient("mall-server")
public interface LoginFeginClient {

    @PostMapping(value = "/login/getLoginByPhoneAndCaptch")
    LoginResp getLoginByPhoneAndCaptch(@RequestBody LoginByCaptchaOrPassword loginByCaptchaOrPassword);

    @PostMapping(value = "/login/getLoginByPhoneAndPassword")
    LoginResp getLoginByPhoneAndPassword(@RequestBody LoginByCaptchaOrPassword loginByCaptchaOrPassword);

    @PostMapping(value = "/login/loginByToken")
    LoginResp loginByToken(@RequestBody BaseRequest baseRequest,@RequestParam("token") String token);
}
