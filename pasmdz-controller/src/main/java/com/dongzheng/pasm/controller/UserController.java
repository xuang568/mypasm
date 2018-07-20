package com.dongzheng.pasm.controller;


import com.dongzheng.pasm.base.Data;
import com.dongzheng.pasm.base.ResDTO;
import com.dongzheng.pasm.core.common.JsonResult;
import com.dongzheng.pasm.core.entity.Clientquery;
import com.dongzheng.pasm.core.entity.Role;
import com.dongzheng.pasm.core.entity.User;
import com.dongzheng.pasm.core.service.IRoleService;
import com.dongzheng.pasm.core.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = {"/index"})
    public String index1(ModelMap modelMap) {
        Page<User> page = userService.findAll(getPageRequest());
        modelMap.put("pageInfo", page);
        return "user/index";
    }

    @ResponseBody
    @RequestMapping(value = {"/index"}, method = RequestMethod.POST)
    public ResDTO<Data> index(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        ResDTO<Data> resDTO = new ResDTO<>();
        Data data = new Data();
        try {
            System.out.println("请求入参：" + pageNum + ":" + pageSize);
            Pageable pageable = new PageRequest(pageNum, pageSize);
            Page<User> page = userService.findByPage(pageable);
            data.setList(page);
            resDTO.setSuccess(true);
            resDTO.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            resDTO.setSuccess(false);
        }
        return resDTO;

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "user/form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap map) {
        User user = userService.find(id);
        map.put("user", user);
        return "user/form";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(User user, ModelMap map) {
        try {
            userService.saveOrUpdate(user);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id, ModelMap map) {
        try {
            userService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping(value = "/grant/{id}", method = RequestMethod.GET)
    public String grant(@PathVariable Integer id, ModelMap map) {
        User user = userService.find(id);
        map.put("user", user);

        Set<Role> set = user.getRoles();
        List<Integer> roleIds = new ArrayList<Integer>();
        for (Role role : set) {
            roleIds.add(role.getId());
        }
        map.put("roleIds", roleIds);

        List<Role> roles = roleService.findAll();
        map.put("roles", roles);
        return "user/grant";
    }

    @ResponseBody
    @RequestMapping(value = "/grant/{id}", method = RequestMethod.POST)
    public JsonResult grant(@PathVariable Integer id, String[] roleIds, ModelMap map) {
        try {
            userService.grant(id, roleIds);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping(value = "/updatePwd", method = RequestMethod.GET)
    public String updatePwd() {
        return "user/updatePwd";
    }

    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult updatePwd(String oldPassword, String password1, String password2) {
        try {
            Subject subject = SecurityUtils.getSubject();
            Object principal = subject.getPrincipal();
            if (principal == null) {
                return JsonResult.failure("您尚未登录");
            }
            userService.updatePwd((User) principal, oldPassword, password1, password2);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }
}
