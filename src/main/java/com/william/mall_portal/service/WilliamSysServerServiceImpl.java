package com.william.mall_portal.service;

import com.william.mall_portal.service.feginclient.SysServerFeginClient;
import com.william.pojo.Result;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/28 15:23
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamSysServerServiceImpl {

    @Autowired
    private SysServerFeginClient sysServerFeginClient;

    public Result getProtocolByType(PublicReq publicReq, String uid) {
        return sysServerFeginClient.getProtocolByType(publicReq,uid);
    }
}
