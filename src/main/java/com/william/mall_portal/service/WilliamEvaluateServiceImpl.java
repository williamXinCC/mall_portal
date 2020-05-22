package com.william.mall_portal.service;

import com.william.constant.RespCodeAndMsg;
import com.william.mall_portal.service.feginclient.EvaluateFeginClient;
import com.william.pojo.Result;
import com.william.pojo.WilliamEvaluate;
import com.william.pojo.req.EvaluateListReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.EvaluateCountResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品评价
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/19 16:34
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamEvaluateServiceImpl {

    @Autowired
    private EvaluateFeginClient evaluateFeginClient;

    public Result getEvaluateListByGoodsIdAndType(EvaluateListReq evaluateListReq, String uid) {
        List<WilliamEvaluate> evaluateList = evaluateFeginClient.getEvaluateListByGoodsIdAndType(evaluateListReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,evaluateList);
    }


    /**
     * 商品评价分类 统计
     * @author     xinchuang
     * @param publicReq :
     * @return : com.william.pojo.Result
     */
    public Result getCountByType(PublicReq publicReq) {
        EvaluateCountResp evaluateCountResp = evaluateFeginClient.getCountByType(publicReq);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,evaluateCountResp);
    }
}
