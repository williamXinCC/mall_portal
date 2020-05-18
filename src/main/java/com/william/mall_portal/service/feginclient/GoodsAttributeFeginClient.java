package com.william.mall_portal.service.feginclient;

import com.william.pojo.WilliamGoodsAttribute;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/6 11:55
 * @since Copyright(c) 爱睿智健康科技
 */
@FeignClient("william-server")
public interface GoodsAttributeFeginClient {

    @GetMapping(value = "/goods-attribute/getGoodsAttributes")
    List<WilliamGoodsAttribute> getGoodsAttributes(@RequestParam(value = "goodsId") String goodsId);
}
