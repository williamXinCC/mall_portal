package com.william.mall_portal.service;

import cn.hutool.captcha.CaptchaUtil;
import com.william.constant.Constant;
import com.william.constant.Consts;
import com.william.constant.RespCodeAndMsg;
import com.william.mall_portal.redis.RedisService;
import com.william.mall_portal.service.feginclient.LoginFeginClient;
import com.william.pojo.Result;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.LoginByCaptchaOrPassword;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.LoginResp;
import com.william.utils.CaptchUtils;
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

    @Autowired
    private RedisService redisService;

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

    /**
     * 发送短信验证码
     * @author     xinchuang
     * @param publicReq :
     * @return : com.william.pojo.Result
     */
    public Result sendCaptch(PublicReq publicReq) {
        // 验证码
        String captch = CaptchUtils.getRandomCode();
        // 手机号
        String phone = publicReq.getKeyName();
        // 登录验证码规则 phone + LOGIN:CAPTCH
        redisService.setExpire(phone.concat(Consts.LOGIN_CAPTCH_SUFFIX),captch,Consts.REDIS_CAPTCH_EXPIRE_TIME);
        // 发送短信 ...
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS);
    }

    /**
     * token登录
     * @author     xinchuang
     * @param baseRequest :
     * @param token :
     * @return : com.william.pojo.Result
     */
    public Result loginByToken(BaseRequest baseRequest, String token) {
        LoginResp loginResp = loginFeginClient.loginByToken(baseRequest,token);
        if(Objects.nonNull(loginResp)){
            return Result.getResult(RespCodeAndMsg.LOGIN_SUCCESS,loginResp);
        }
        return Result.getResult(RespCodeAndMsg.LOGIN_ERROR);

    }
}
