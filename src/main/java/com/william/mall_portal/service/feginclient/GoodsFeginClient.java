package com.william.mall_portal.service.feginclient;

import com.william.pojo.WilliamGoods;
import com.william.pojo.WilliamGoodsAttribute;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PageReq;
import com.william.pojo.req.PublicReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/19 15:46
 * @since Copyright(c) 爱睿智健康科技
 */
@FeignClient("mall-server")
public interface GoodsFeginClient {

    @PostMapping(value = "/goods/getGoodsInfo")
    WilliamGoods getGoodsInfo(@RequestBody PublicReq publicReq,@RequestParam(value = "uid",required = false) String uid);

    @GetMapping(value = "/goods/getGoodsAttributes")
    List<WilliamGoodsAttribute> getGoodsAttributes(@RequestParam("goodsId") String goodsId);

    @PostMapping(value = "/goods/getGoodsListByCategory")
    List<WilliamGoods> getGoodsListByCategory(@RequestBody PageConditionReq pageConditionReq,@RequestParam(value = "uid",required = false) String uid);

    @PostMapping(value = "/goods/getNewGoodsPageCondition")
    List<WilliamGoods> getNewGoodsPageCondition(@RequestBody PageConditionReq pageConditionReq,@RequestParam(value = "uid",required = false) String uid);

    @PostMapping(value = "/goods/getRecommendGoodsByPage")
    List<WilliamGoods> getRecommendGoodsByPage(@RequestBody PageReq pageReq,@RequestParam(value = "uid",required = false) String uid);

    @PostMapping(value = "/goods/getHotGoodsByPage")
    List<WilliamGoods> getHotGoodsByPage(@RequestBody PageReq pageReq,@RequestParam(value = "uid",required = false) String uid);

    @PostMapping(value = "/goods/getGuessYouLike")
    List<WilliamGoods> getGuessYouLike(@RequestBody PageConditionReq pageConditionReq,@RequestParam(value = "uid",required = false) String uid);
}
