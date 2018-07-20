package com.dongzheng.pasm.controller;

import com.dongzheng.pasm.core.entity.Count;
import com.dongzheng.pasm.core.entity.User;
import com.dongzheng.pasm.core.service.IClientqueryService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * <p>
 *
 * </p>
 *
 * @author xa
 * @since 2018-06-13
 */
@Controller
@RequestMapping("/count")
public class CountController extends BaseController{
    @Autowired
    private IClientqueryService clientqueryService;

    @RequestMapping(value = {"/index"})
    public String index(ModelMap modelMap) {
        try {
            //获取当前登陆用户id 即查询用户的门店号
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            //查询所有用户数
            Integer total = clientqueryService.queryTotal(user.getId());
            //查询预授信通过人数
            Integer success =clientqueryService.querySuccess(user.getId());
            //查询预授信未通过人数
            Integer fail = clientqueryService.queryFail(user.getId());
            //查询预授信未知结果人数
            Integer querying = clientqueryService.queryUnknown(user.getId());
            Count count=new Count(total,success,fail,querying,success/(double)total.intValue());
            modelMap.put("count",count);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "count/index";
    }
}
