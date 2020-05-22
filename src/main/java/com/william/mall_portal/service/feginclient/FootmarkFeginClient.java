package com.william.mall_portal.service.feginclient;

import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PageReq;
import com.william.pojo.resp.BrowsingHisResp;
import com.william.pojo.resp.FootmarkResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/18 18:08
 * @since Copyright(c) 爱睿智健康科技
 */
@FeignClient("mall-server")
public interface FootmarkFeginClient {

    @PostMapping(value = "/footmark/getFootmarkByPageAndDate")
    List<BrowsingHisResp> getFootmarkByPageAndDate(@RequestBody PageConditionReq pageConditionReq, @RequestParam(value = "uid") String uid);

    @PostMapping(value = "/footmark/saveFootmarkByUidAndGoodsId")
    void saveFootmarkByUidAndGoodsId(@RequestParam("goodsId") String keyName,@RequestParam("uid") String uid);

    @PostMapping(value = "/footmark/getFootmarkByUid")
    List<FootmarkResp> getFootmarkByUid(@RequestBody PageReq pageReq,@RequestParam("uid") String uid);
}
