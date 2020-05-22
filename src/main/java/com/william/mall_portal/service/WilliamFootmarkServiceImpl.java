package com.william.mall_portal.service;

import com.william.constant.RespCodeAndMsg;
import com.william.mall_portal.service.feginclient.FootmarkFeginClient;
import com.william.pojo.Result;
import com.william.pojo.WilliamBrowsingHistory;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PageReq;
import com.william.pojo.resp.BrowsingHisResp;
import com.william.pojo.resp.FootmarkResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/18 18:07
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamFootmarkServiceImpl {

    @Autowired
    private FootmarkFeginClient footmarkFeginClient;

    /**
     * 我的足迹
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    public Result getFootmarkByPageAndDate(PageConditionReq pageConditionReq, String uid) {
        List<BrowsingHisResp> footmarkList = footmarkFeginClient.getFootmarkByPageAndDate(pageConditionReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,footmarkList);
    }

    public Result saveFootmarkByUidAndGoodsId(String keyName, String uid) {
        footmarkFeginClient.saveFootmarkByUidAndGoodsId(keyName,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS);
    }

    public Result getFootmarkByUid(PageReq pageReq, String uid) {
        List<FootmarkResp> footmarkRespList =  footmarkFeginClient.getFootmarkByUid(pageReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,footmarkRespList);
    }
}
