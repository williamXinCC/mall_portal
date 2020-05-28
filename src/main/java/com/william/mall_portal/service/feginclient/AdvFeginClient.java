package com.william.mall_portal.service.feginclient;

import com.william.pojo.WilliamPicture;
import com.william.pojo.req.PublicReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/25 10:38
 * @since Copyright(c) 爱睿智健康科技
 */
@FeignClient("mall-server")
public interface AdvFeginClient {

    @PostMapping(value = "/adv/getAdvListByCategory")
    List<WilliamPicture> getAdvListByCategory(@RequestBody PublicReq publicReq,@RequestParam(value = "uid",required = false) String uid);
}
