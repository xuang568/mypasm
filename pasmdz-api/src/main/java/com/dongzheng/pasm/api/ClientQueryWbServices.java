package com.dongzheng.pasm.api;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Title: ClientQueryWbService 人行征信回调接口
 *Version:1.0.0
  * @author xuang
 */
@WebService
public interface ClientQueryWbServices {

    /** 供客户端调用方法  该方法是非静态的，会被发布
     * @param data  传入参数
     * @return String 返回结果
     * */
    @WebMethod
    public String clientQueryNotify(String data);
}
