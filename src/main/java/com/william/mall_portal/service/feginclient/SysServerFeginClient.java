package com.william.mall_portal.service.feginclient;

import com.william.pojo.WilliamSysStatic;
import com.william.pojo.req.PublicReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/28 15:24
 * @since Copyright(c) 爱睿智健康科技
 */
@FeignClient("mall-server")
public interface SysServerFeginClient {

     @PostMapping(value = "/sys-server/getProtocolByType")
     WilliamSysStatic getProtocolByType(@RequestBody PublicReq publicReq,@RequestParam("uid") String uid);
}
