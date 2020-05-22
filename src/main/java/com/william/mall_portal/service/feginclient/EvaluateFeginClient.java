package com.william.mall_portal.service.feginclient;

import com.william.pojo.WilliamEvaluate;
import com.william.pojo.req.EvaluateListReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.EvaluateCountResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/19 16:36
 * @since Copyright(c) 爱睿智健康科技
 */
@FeignClient("mall-server")
public interface EvaluateFeginClient {

    @PostMapping(value = "/evaluate/getEvaluateListByGoodsIdAndType")
    List<WilliamEvaluate> getEvaluateListByGoodsIdAndType(@RequestBody EvaluateListReq evaluateListReq,@RequestParam("uid") String uid);

    @GetMapping(value = "/evaluate/getEvaluateCountByGoodsId")
    Integer getEvaluateCountByGoodsId(@RequestParam("goodsId") String goodsId);

    @PostMapping(value = "/evaluate/getCountByType")
    EvaluateCountResp getCountByType(@RequestBody PublicReq publicReq);
}
