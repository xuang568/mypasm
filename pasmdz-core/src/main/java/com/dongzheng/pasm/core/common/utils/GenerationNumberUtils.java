package com.dongzheng.pasm.core.common.utils;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 *序列号生产工具
 * </p>
 *
 * @author xa
 * @since 2018-06-10
 */
public class GenerationNumberUtils {

    /**
     * 预授信申请单号生成
     *
     * @param
     * @param
     * @return
     */
    public static String getApplicationNo(Date date) {
        StringBuilder applicationNo=new StringBuilder();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        applicationNo.append("Pasmdz-");
        applicationNo.append(format);
        applicationNo.append("-"+UUID.randomUUID().toString().substring(0,6));
        return applicationNo.toString();
    }
}
