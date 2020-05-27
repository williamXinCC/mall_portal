package com.william.mall_portal.controller;

import com.william.mall_portal.service.WilliamFootmarkServiceImpl;
import com.william.pojo.Result;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PageReq;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/18 18:04
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/william-footmark")
public class WilliamFootmarkController {

    @Autowired
    private WilliamFootmarkServiceImpl williamFootmarkService;

    /**
     * 删除浏览记录
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/deleteFootmarkById")
    public Result deleteFootmarkById(@RequestBody PublicReq publicReq,@RequestHeader("uid")String uid){
        return williamFootmarkService.deleteFootmarkById(publicReq,uid);
    }

    /**
     * 保存浏览记录
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : void
     */
    @PostMapping(value = "/saveFootmarkByUidAndGoodsId")
    public Result saveFootmarkByUidAndGoodsId(@RequestBody PublicReq publicReq, @RequestHeader(value = "uid")String uid){
        return williamFootmarkService.saveFootmarkByUidAndGoodsId(publicReq.getKeyName(),uid);
    }

    /**
     * 我的足迹列表
     * @author     xinchuang
     * @param pageReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getFootmarkByUid")
    public Result getFootmarkByUid(@RequestBody PageReq pageReq,@RequestHeader(value = "uid")String uid){
        return williamFootmarkService.getFootmarkByUid(pageReq,uid);
    }

    /**
     * 日期获取 足迹
     * @author     xinchuang
     * @param pageConditionReq : keyName 为日期时间
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getFootmarkByPageAndDate")
    public Result getFootmarkByPageAndDate(@RequestBody PageConditionReq pageConditionReq, @RequestHeader(value = "uid")String uid){
        return williamFootmarkService.getFootmarkByPageAndDate(pageConditionReq,uid);
    }
}
