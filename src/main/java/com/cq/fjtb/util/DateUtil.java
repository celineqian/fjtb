package com.cq.fjtb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Celine Q
 * @create: 2018-09-17 23:33
 **/
public class DateUtil {


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
}

