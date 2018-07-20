package com.dongzheng.pasm.controller;

import com.dongzheng.pasm.base.Data;
import com.dongzheng.pasm.base.ReqDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *
 * </p>
 *
 * @author xa
 * @since 2018-06-10
 */
@CrossOrigin
@Controller
public class LoginController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public ReqDTO<Data> login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        ReqDTO<Data> reqDTO=new ReqDTO<>();
        Data data=new Data();
        try {
            logger.info("当前用户"+username+"请求登陆");
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            logger.info("当前用户"+username+"登陆成功");
            reqDTO.setSuccess(true);
            reqDTO.setData(data);
            return reqDTO;
        } catch (AuthenticationException e) {
            logger.info("当前用户"+username+"登陆失败"+password);
        }
        reqDTO.setSuccess(false);
        reqDTO.setData(data);
        return reqDTO;
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return redirect("login");
    }

}
