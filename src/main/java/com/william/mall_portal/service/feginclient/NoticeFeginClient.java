package com.william.mall_portal.service.feginclient;

import com.william.pojo.WilliamSysNotice;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/21 9:59
 * @since Copyright(c) 爱睿智健康科技
 */
@FeignClient("mall-server")
public interface NoticeFeginClient {

    @PostMapping(value = "/notice/getNoticeInfo")
    WilliamSysNotice getNoticeInfo(@RequestBody PublicReq publicReq,@RequestParam("uid") String uid);

    @PostMapping(value = "/notice/getNoticeListByType")
    List<WilliamSysNotice> getNoticeListByType(@RequestBody PageConditionReq pageConditionReq, @RequestParam("uid") String uid);
}
