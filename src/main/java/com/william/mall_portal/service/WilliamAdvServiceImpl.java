package com.william.mall_portal.service;

import com.william.constant.RespCodeAndMsg;
import com.william.mall_portal.service.feginclient.AdvFeginClient;
import com.william.pojo.Result;
import com.william.pojo.WilliamPicture;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/25 10:36
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamAdvServiceImpl {

    @Autowired
    private AdvFeginClient advFeginClient;

    /**
     * 广告
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    public Result getAdvListByCategory(PublicReq publicReq, String uid) {
        List<WilliamPicture> advList = advFeginClient.getAdvListByCategory(publicReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,advList);
    }
}
