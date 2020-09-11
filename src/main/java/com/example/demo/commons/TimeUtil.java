package com.example.demo.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static final SimpleDateFormat SECOND_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前时间时间戳
     */
    public static Long getCurrentTimestamp() {
        Long timestamp = System.currentTimeMillis();
        return timestamp;
    }

    /**
     * 解析标准时间格式参数为十三位时间戳
     *
     * @param time 标准格式时间
     * @param sdf  时间格式
     */
    public static Long parseTime(String time, SimpleDateFormat sdf) throws ParseException {
        try {
            Date date = sdf.parse(time);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            throw new ParseException("时间格式解析异常", 999);
        }
    }

    /**
     * 格式化时间戳为标准格式时间
     *
     * @param timeStamp 时间戳
     * @param sdf       时间格式
     */
    public static String formatTime(Long timeStamp, SimpleDateFormat sdf) {
        Date date = new Date(timeStamp);
        String time = sdf.format(date);
        return time;
    }
}