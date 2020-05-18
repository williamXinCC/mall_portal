package com.william.mall_portal.config;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * 日期格式化
 * @author     xinchuang
 * @date       2019/12/11 17:30
 * @version    v1.0
 * @since      @Copyright(c) 爱睿智健康科技(北京)有限公司
 */
public class MyDateConvert implements Converter<String, Date> {

    private final static DateTimeFormatter DATE_TIME_FORMAT_1 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    private final static DateTimeFormatter DATE_TIME_FORMAT_2 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
    private final static DateTimeFormatter DATE_TIME_FORMAT_3 = DateTimeFormat.forPattern("yyyy-MM-dd");

    @Override
    public Date convert(String source) {
        Date date = null;
        if (StringUtils.isBlank(source)) {
            return null;
        }
        try {
            date = DATE_TIME_FORMAT_1.parseDateTime(source).toDate();
            return date;
        } catch (Exception e) {
        }
        try {
            date = DATE_TIME_FORMAT_2.parseDateTime(source).toDate();
            return date;
        } catch (Exception e) {
        }
        try {
            date = DATE_TIME_FORMAT_3.parseDateTime(source).toDate();
            return date;
        } catch (Exception e) {
        }
        throw new IllegalArgumentException(source);
    }
}