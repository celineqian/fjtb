package com.cq.fjtb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Celine Q
 * @create: 2018-09-17 23:33
 **/
public class DateUtil {


    /**
     * 日期和当前时间比是否过期
     * @param expireDate
     * @return true: 已过期; false 未过期
     */
    public static boolean isExpired(String expireDate) {
        if (expireDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
            Date date = null;
            try {
                date = sdf.parse(expireDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date currentDate = new Date();
            if(date.before(currentDate))
                return true;
        }
        return false;
    }

    /**
     * 日期转换成字符串
     * @param date
     * @return str
     */
    public static String DateToStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }
}

