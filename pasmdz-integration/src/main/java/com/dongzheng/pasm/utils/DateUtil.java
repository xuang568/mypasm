package com.dongzheng.pasm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式工具
 * */
public class DateUtil {

   private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String format(Date date){
      return sdf.format(date);
    }
}
