package com.william.mall_portal.controller;

import com.william.mall_portal.service.WilliamSysServerServiceImpl;
import com.william.pojo.Result;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 系统相关服务
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/28 15:19
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/william-sys-server")
public class WilliamSysServerController {

    @Autowired
    private WilliamSysServerServiceImpl williamSysServerService;

    /**
     * 根据分类,获取协议
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getProtocolByType")
    public Result getProtocolByType(@RequestBody PublicReq publicReq, @RequestHeader("uid")String uid){
        return williamSysServerService.getProtocolByType(publicReq,uid);
    }
}
