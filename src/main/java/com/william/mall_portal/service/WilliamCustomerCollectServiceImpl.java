package com.william.mall_portal.service;

import com.william.constant.RespCodeAndMsg;
import com.william.mall_portal.service.feginclient.CollectFeginClient;
import com.william.pojo.Result;
import com.william.pojo.WilliamGoods;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.CollectReq;
import com.william.pojo.req.PageConditionReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/20 10:03
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamCustomerCollectServiceImpl {

    @Autowired
    private CollectFeginClient collectFeginClient;

    public void saveCollect(CollectReq collectReq, String uid) {
        collectFeginClient.saveCollect(collectReq,uid);
    }

    public void deleteCollect(CollectReq collectReq, String uid) {
        collectFeginClient.deleteCollect(collectReq,uid);
    }

    /**
     * 我的收藏
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    public Result getMyCollect(PageConditionReq pageConditionReq, String uid) {
        List<WilliamGoods> collectGoods =  collectFeginClient.getMyCollect(pageConditionReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,collectGoods);
    }
}
