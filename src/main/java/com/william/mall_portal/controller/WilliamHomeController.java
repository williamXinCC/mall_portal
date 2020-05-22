package com.william.mall_portal.controller;

import com.william.mall_portal.service.WilliamHomeServiceImpl;
import com.william.pojo.Result;
import com.william.pojo.req.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/20 16:16
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/william-home")
public class WilliamHomeController {

    @Autowired
    private WilliamHomeServiceImpl williamHomeService;

    /**
     * 首页
     * @author     xinchuang
     * @param baseRequest :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getHomePage")
    public Result getHomePage(@RequestBody BaseRequest baseRequest){
        return williamHomeService.getHomePage(baseRequest);
    }
}
