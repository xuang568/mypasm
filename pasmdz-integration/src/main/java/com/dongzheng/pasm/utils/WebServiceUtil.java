package com.dongzheng.pasm.utils;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * @author xuang
 * @date 2018年7月23日
 * WebServiceUtil 工具类
 */
@Repository
public class WebServiceUtil {
    private static Logger logger = Logger.getLogger(WebServiceUtil.class);

    /**
    * webservice zhong ke ruan 服务接口
    * */
    public static String queryPcmuat(String url, String OperatorName, String xml) {
        try {
            // 创建一个Service实例
            Service service = new Service();
            // 创建Call实例
            Call call = (Call) service.createCall();
            // 为Call设置服务的位置
            call.setTargetEndpointAddress(new java.net.URL(url));
            call.setOperationName(OperatorName);
            call.setTimeout(new Integer(-1));
            String res = "";
            if (xml == null || xml.equals("")) {
                res = (String) call.invoke(new Object[]{});
            } else {
                res = (String) call.invoke(new Object[]{xml});
            }
            return res;
        } catch (Exception ex) {
            logger.warn("WebServiceUtil.queryPcmuat fail："+ex);
            return "";
        }
    }
}
