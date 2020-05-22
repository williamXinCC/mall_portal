package com.william.mall_portal.controller;

import com.william.mall_portal.service.WilliamNoticeServiceImpl;
import com.william.pojo.Result;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 公告
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/20 17:34
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/william-notice")
public class WilliamNoticController {

    @Autowired
    private WilliamNoticeServiceImpl williamNoticeService;

    /**
     * 公告 列表
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getNoticeListByType")
    public Result getNoticeListByType(@RequestBody PageConditionReq pageConditionReq, @RequestHeader(value = "uid")String uid){
        return williamNoticeService.getNoticeListByType(pageConditionReq,uid);
    }

    /**
     * 公告 通知详情
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getNoticeInfo")
    public Result getNoticeInfo(@RequestBody PublicReq publicReq, @RequestHeader(value = "uid")String uid){
        return williamNoticeService.getNoticeInfo(publicReq,uid);
    }

}
