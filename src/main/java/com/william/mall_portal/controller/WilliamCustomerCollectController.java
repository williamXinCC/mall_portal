package com.william.mall_portal.controller;


import com.william.constant.RespCodeAndMsg;
import com.william.mall_portal.service.WilliamCustomerCollectServiceImpl;
import com.william.pojo.Result;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.CollectReq;
import com.william.pojo.req.PageConditionReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 收藏表 前端控制器
 * </p>
 *
 * @author mybatisPlusGenerator
 * @since 2019-12-19
 */
@RestController
@RequestMapping("/william-collect")
public class WilliamCustomerCollectController {

    @Autowired
    private WilliamCustomerCollectServiceImpl williamCustomerCollectServiceImpl;

    /**
     * 我的收藏
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getMyCollect")
    public Result getMyCollect(@RequestBody PageConditionReq pageConditionReq, @RequestHeader(value = "uid")String uid){
        return williamCustomerCollectServiceImpl.getMyCollect(pageConditionReq,uid);
    }


    /**
     * 收藏
     * @author     xinchuang
     * @param collectReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/saveCollect")
    public Result saveCollect(@RequestBody CollectReq collectReq, @RequestHeader(value = "uid")String uid){
        williamCustomerCollectServiceImpl.saveCollect(collectReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS);
    }


    /**
     * 取消收藏
     * @author     xinchuang
     * @param collectReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/deleteCollect")
    public Result deleteCollect(@RequestBody CollectReq collectReq, @RequestHeader(value = "uid")String uid){
        williamCustomerCollectServiceImpl.deleteCollect(collectReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS);
    }
}
