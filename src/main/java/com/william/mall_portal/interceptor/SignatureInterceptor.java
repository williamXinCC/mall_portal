package com.william.mall_portal.interceptor;

import cn.hutool.core.util.StrUtil;
import com.william.constant.RespCodeAndMsg;
import com.william.pojo.Result;
import com.william.utils.AESCipher;
import com.william.utils.JsonUtils;
import com.william.utils.Md5Util;
import com.william.mall_portal.redis.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;

/**
 *   请求拦截器
 * @author     xinchuang
 * @date       2018/11/28 18:59
 * @version    v1.1
 * @since      @Copyright(c) 爱睿智健康科技(北京)有限公司
 */
//@Component
public class SignatureInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(SignatureInterceptor.class);

    @Autowired
    private HashSet<String> set;

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//        String client = request.getHeader("client");
//        if(Objects.equals(client,"miniWeChat")){
//            return true;
//        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        // 获取当前请求的url
        String requestURI = request.getRequestURI();
        String remoteAddr = request.getRemoteAddr();
        log.warn("请求IP 地址 :" + remoteAddr);
        log.warn("请求接口地址 : " + requestURI);
        // 过滤请求
        if (set.contains(requestURI)) {return true;}
        // 获取请求uid
        String uid = request.getHeader("uid");
        // 获取请求时间戳
        String expire = request.getHeader("expire");
        // 获取请求签名
        String sign = request.getHeader("sign");
        // 获取请求token
        String token = request.getHeader("token");
        if(StrUtil.hasBlank(uid,expire,sign,token)){
            log.warn("非法请求,签名参数为空");
            String s = JsonUtils.obj2String(Result.getResult(RespCodeAndMsg.REQ_NON_100004));
            log.warn(s);
            response.getWriter().print(s);
            return false;
        }
        // 解密uid
        uid = AESCipher.decrypt(uid);
        // 解密时间戳
        expire = AESCipher.decrypt(expire);
        // 获取当前时间
        long nowTime = System.currentTimeMillis();
        // 判断请求时间是否失效
        long vailedExpire = Long.parseLong(expire);
        if(vailedExpire <= nowTime){
            log.warn("请求已过期!");
            String s = JsonUtils.obj2String(Result.getResult(RespCodeAndMsg.REQ_TIMR_OUT_10001));
            log.warn(s);
            response.getWriter().print(s);
            return false;
        }
        // 通过uid获取token
        String userToken = redisService.getStr(uid);
        // 验证token
        if(StringUtils.isBlank(userToken) || !userToken.equals(token)){
            log.warn("token验证失败!");
            String s = JsonUtils.obj2String(Result.getResult(RespCodeAndMsg.TOKEN_CHECK_FAILED_10002));
            log.warn(s);
            response.getWriter().print(s);
            return false;
        }
        // md5验签
        String signnature = Md5Util.md5(requestURI + token + expire);
        // 验证签名
        if(!signnature.equalsIgnoreCase(sign)){
            log.warn("验证签名失败!");
            String s = JsonUtils.obj2String(Result.getResult(RespCodeAndMsg.SIGN_CHECK_FAILED_10003));
            log.warn(s);
            response.getWriter().print(s);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
    }


}
