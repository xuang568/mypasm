/*
package com.dongzheng.pasm.config.shiro;

import com.alibaba.fastjson.JSONObject;
import com.dongzheng.pasm.base.ShiroConstant;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ShiroRoleAuthorizationFilter  extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if(req.getMethod().equals(RequestMethod.OPTIONS.name())) {
            resp.setStatus(HttpStatus.OK.value());
            return true;
        }
        //前端Ajax请求时requestHeader里面带一些参数，用于判断是否是前端的请求
        String ajaxHeader = req.getHeader(ShiroConstant.USERID);
        if (ajaxHeader != null || req.getHeader("wkcheck") != null) {
            //前端Ajax请求，则不会重定向
            resp.setHeader("Access-Control-Allow-Origin",  req.getHeader("Origin"));
            resp.setHeader("Access-Control-Allow-Credentials", "true");
            resp.setContentType("application/json; charset=utf-8");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            JSONObject result = new JSONObject();
            result.put("message", "权限不足！");
            result.put("statusCode", -403);
            out.println(result);
            out.flush();
            out.close();
            return false;
        }
        return super.onAccessDenied(request, response);
    }
}
*/
