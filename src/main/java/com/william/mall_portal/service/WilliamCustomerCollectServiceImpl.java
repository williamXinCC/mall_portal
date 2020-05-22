package com.william.mall_portal.service;

import com.william.mall_portal.service.feginclient.CollectFeginClient;
import com.william.pojo.req.CollectReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
