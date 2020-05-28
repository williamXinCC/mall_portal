package com.william.mall_portal.service.feginclient;

import com.william.pojo.WilliamGoods;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.CollectReq;
import com.william.pojo.req.PageConditionReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/20 10:34
 * @since Copyright(c) 爱睿智健康科技
 */
@FeignClient("mall-server")
public interface CollectFeginClient {

    @PostMapping(value = "/collect/saveCollect")
    void saveCollect(@RequestBody CollectReq collectReq,@RequestParam("uid") String uid);

    @PostMapping(value = "/collect/deleteCollect")
    void deleteCollect(@RequestBody CollectReq collectReq,@RequestParam("uid") String uid);

    @PostMapping(value = "/collect/getAlreadyCollect")
    Integer getAlreadyCollect(@RequestBody CollectReq collectReq,@RequestParam("uid") String uid);

    @PostMapping(value = "/collect/getMyCollect")
    List<WilliamGoods> getMyCollect(@RequestBody PageConditionReq pageConditionReq, @RequestParam("uid") String uid);
}
