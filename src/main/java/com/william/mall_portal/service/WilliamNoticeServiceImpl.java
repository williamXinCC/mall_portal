package com.william.mall_portal.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.william.constant.RespCodeAndMsg;
import com.william.mall_portal.service.feginclient.NoticeFeginClient;
import com.william.pojo.Result;
import com.william.pojo.WilliamSysNotice;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/21 9:58
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamNoticeServiceImpl {

    @Autowired
    private NoticeFeginClient noticeFeginClient;

    public Result getNoticeInfo(PublicReq publicReq, String uid) {
        WilliamSysNotice williamSysNotice = noticeFeginClient.getNoticeInfo(publicReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,williamSysNotice);
    }

    public Result getNoticeListByType(PageConditionReq pageConditionReq, String uid) {
        List<WilliamSysNotice> noticeList =  noticeFeginClient.getNoticeListByType(pageConditionReq,uid);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS,noticeList);
    }
}
