package com.william.mall_portal.service.feginclient;

import com.william.pojo.WilliamGoodsCategory;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.resp.CategoryTreeNodesResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/21 11:55
 * @since Copyright(c) 爱睿智健康科技
 */
@FeignClient("mall-server")
public interface GoodsCategoryFeginClient {

    @PostMapping(value = "/goods-category/getGoodsCategoryTreeList")
    List<CategoryTreeNodesResp> getGoodsCategoryTreeList(@RequestBody BaseRequest baseRequest, @RequestParam(value = "uid",required = false) String uid);
}
