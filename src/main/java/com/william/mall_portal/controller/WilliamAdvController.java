package com.william.mall_portal.controller;

import com.william.mall_portal.service.WilliamAdvServiceImpl;
import com.william.pojo.Result;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 广告
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/22 14:08
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/william-adv")
public class WilliamAdvController {

    @Autowired
    private WilliamAdvServiceImpl williamAdvService;

    /**
     * 分类获取广告
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getAdvListByCategory")
    public Result getAdvListByCategory(@RequestBody PublicReq publicReq, @RequestHeader(value = "uid") String uid){
        return williamAdvService.getAdvListByCategory(publicReq,uid);
    }
}
