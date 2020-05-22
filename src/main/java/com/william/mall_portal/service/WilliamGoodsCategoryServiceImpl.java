package com.william.mall_portal.service;

import com.william.constant.RespCodeAndMsg;
import com.william.mall_portal.service.feginclient.GoodsCategoryFeginClient;
import com.william.pojo.Result;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.resp.CategoryTreeNodesResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/21 11:54
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamGoodsCategoryServiceImpl {

    @Autowired
    private GoodsCategoryFeginClient goodsCategoryFeginClient;

    public Result getGoodsCategoryTreeList(BaseRequest baseRequest, String uid) {
        List<CategoryTreeNodesResp> categoryList =  goodsCategoryFeginClient.getGoodsCategoryTreeList(baseRequest,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,categoryList);
    }
}
