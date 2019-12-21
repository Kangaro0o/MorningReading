package com.mr.adapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LiuWen
 * @date 2019-12-19 19:18
 */
public class DateTimeAdapter {

    /**
     * 将字符串表示的时间，如：2019-12-19
     * 转化成距离1970-1-1的天数，"2019-12-19" -> 18249
     * 1576684800000
     */
    public long strDateToInt(String time) {
        Date date = null;
        try {
            date = DateFormat.getDateInstance().parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert date != null;
        long res = date.getTime();
        return (res - 8 * 60 * 1000) / (24 * 60 * 60 * 1000) + 1;
    }

    /**
     * 将距离1970-1-1的天数，转化成字符串表示的时间
     * 18249 -> 2019-12-19
     */
    public String intDateToStr(int time) {
        long res = (time * 24L * 60L * 60L * 1000L) - (8L * 60L * 1000L);
        Date date = new Date(res);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /***
     * 将包含日期的字符串转换成特定格式的日期字符串：yyyy-MM-dd
     * @param str：日期
     * @return ：返回如2019-02-08格式的字符串
     */
    public String dateFormat(String str) throws ParseException {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=dateFormat.parse(str);
        str=dateFormat.format(date);
        return str;
    }
}
