package com.william.mall_portal.service;

import com.william.constant.RespCodeAndMsg;
import com.william.mall_portal.service.feginclient.CollectFeginClient;
import com.william.mall_portal.service.feginclient.EvaluateFeginClient;
import com.william.mall_portal.service.feginclient.GoodsFeginClient;
import com.william.pojo.Result;
import com.william.pojo.WilliamEvaluate;
import com.william.pojo.WilliamGoods;
import com.william.pojo.WilliamGoodsAttribute;
import com.william.pojo.req.*;
import com.william.pojo.resp.GoodsInfoPageResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/19 15:43
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamGoodsServiceImpl {

    @Autowired
    private GoodsFeginClient goodsFeginClient;

    @Autowired
    private EvaluateFeginClient evaluateFeginClient;

    @Autowired
    private CollectFeginClient collectFeginClient;

    public Result getGoodsInfoPage(PublicReq publicReq, String uid) {
        // 商品基本详情
        WilliamGoods goodsInfo = goodsFeginClient.getGoodsInfo(publicReq, uid);
        // 商品id
        String goodsId = publicReq.getKeyName();
        // 评价
        EvaluateListReq evaluateListReq = new EvaluateListReq();
        evaluateListReq.setType("1");
        evaluateListReq.setGoodsId(publicReq.getKeyName());
        List<WilliamEvaluate> evaluateList = evaluateFeginClient.getEvaluateListByGoodsIdAndType(evaluateListReq,uid);
        // 评价总数
        Integer evaluateTotalCount = evaluateFeginClient.getEvaluateCountByGoodsId(goodsId);
        // 服务内容

        // 店铺信息

        // 是否为客户已收藏商品
        CollectReq collectReq = new CollectReq();
        collectReq.setCollectId(goodsId);
        collectReq.setType("1");
        Integer alreadyCollect = collectFeginClient.getAlreadyCollect(collectReq, uid);
        // 规格参数
        List<WilliamGoodsAttribute> goodsAttributes = goodsFeginClient.getGoodsAttributes(goodsId);
        // 拼接结果
        GoodsInfoPageResp goodsInfoPageResp = new GoodsInfoPageResp();
        // 商品详情
        goodsInfoPageResp.setWilliamGoods(goodsInfo);
        // 商品评价
        goodsInfoPageResp.setEvaluateList(evaluateList);
        // 商品评价总数
        goodsInfoPageResp.setEvaluateTotalCount(evaluateTotalCount);
        // 商品规格参数
        goodsInfoPageResp.setGoodsAttributeList(goodsAttributes);
        // 是否已收藏
        goodsInfoPageResp.setAlreadyCollect(alreadyCollect);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,goodsInfoPageResp);
    }

    /**
     * 分类商品列表 分页
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    public Result getGoodsListByCategory(PageConditionReq pageConditionReq, String uid) {
        List<WilliamGoods> williamGoodsList = goodsFeginClient.getGoodsListByCategory(pageConditionReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,williamGoodsList);
    }

    /**
     * 新品上市
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    public Result getNewGoodsPageCondition(PageConditionReq pageConditionReq, String uid) {
        List<WilliamGoods> williamGoodsList = goodsFeginClient.getNewGoodsPageCondition(pageConditionReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,williamGoodsList);
    }

    /**
     * 推荐商品
     * @author     xinchuang
     * @param pageReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    public Result getRecommendGoodsByPage(PageReq pageReq, String uid) {
        List<WilliamGoods> williamGoodsList = goodsFeginClient.getRecommendGoodsByPage(pageReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,williamGoodsList);
    }

    /**
     * 热门商品
     * @author     xinchuang
     * @param pageReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    public Result getHotGoodsByPage(PageReq pageReq, String uid) {
        List<WilliamGoods> williamGoodsList = goodsFeginClient.getHotGoodsByPage(pageReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,williamGoodsList);
    }
}
