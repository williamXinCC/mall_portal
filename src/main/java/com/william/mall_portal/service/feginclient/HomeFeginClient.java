package com.william.mall_portal.service.feginclient;

import com.william.pojo.req.BaseRequest;
import com.william.pojo.resp.HomePageResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/20 16:27
 * @since Copyright(c) 爱睿智健康科技
 */
@FeignClient("mall-server")
public interface HomeFeginClient {

    @PostMapping(value = "/home/getHomePage")
    HomePageResp getHomePage(@RequestBody BaseRequest baseRequest);
}
