package com.dongzheng.pasm.controller;

import com.dongzheng.pasm.base.Data;
import com.dongzheng.pasm.base.ReqDTO;
import com.dongzheng.pasm.base.ResDTO;
import com.dongzheng.pasm.core.common.DateEditor;
import com.dongzheng.pasm.core.common.utils.GenerationNumberUtils;
import com.dongzheng.pasm.core.entity.Blacklist;
import com.dongzheng.pasm.core.entity.Clientquery;
import com.dongzheng.pasm.core.entity.User;
import com.dongzheng.pasm.core.service.IBlacklistService;
import com.dongzheng.pasm.core.service.IClientqueryService;
import com.dongzheng.pasm.core.service.SpeciService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
@RequestMapping("/pasm")
public class PreApprovedController extends BaseController {

    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(PreApprovedController.class);

    @Autowired
    private IClientqueryService clientqueryService;

    @Autowired
    private IBlacklistService blacklistService;

    @Autowired
    private SpeciService speciService;

    /**
     * 首次预授信查询页面
     */
    @RequestMapping(value = {"/index"})
    public String index(ModelMap modelMap) {
        return "pasm/index";
    }

    /**
     * 查询历史预授信结果集合
     */
    @ResponseBody
    @RequestMapping(value = {"/history"})
    public ReqDTO<Page> history(ModelMap modelMap) {
        ReqDTO<Page> reqDTO = new ReqDTO<>();
        try {
            /*//获取当前登陆用户id 即查询用户的门店号
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            logger.info("currentUser："+user.getUserName()+"start find all history...");*/
            Page<Clientquery> page = null;
            page = clientqueryService.findAll(getPageRequest());
            reqDTO.setSuccess(true);
            reqDTO.setData(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reqDTO;

    }

    /**
     * 查询历史预授信结果集合
     */
    @ResponseBody
    @RequestMapping(value = {"/history"}, method = RequestMethod.POST)
    public ResDTO<Data> history2(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String idCard) {
        ResDTO<Data> resDTO = new ResDTO<>();
        Data data = new Data();
        try {
            Page<Clientquery> page=null;
            System.out.println("请求入参：" + pageNum + ":" + pageSize + ":" + idCard);
            if (idCard != null) {
                Clientquery clientquery = new Clientquery();
                clientquery.setIdCardNo(idCard);
                page = speciService.findByPageAndParams(clientquery, pageNum, pageSize);
            }else {
                System.out.println("无参查询----");
                Pageable pageable = new PageRequest(pageNum, pageSize);
                //page = clientqueryService.findAll(pageable);
                page=speciService.findByPage(pageable);
            }

            data.setList(page);
            resDTO.setSuccess(true);
            resDTO.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            resDTO.setSuccess(false);
        }
        return resDTO;

    }


    /**
     * 发起查询请求，返回查询页面到前端
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(ModelMap modelMap) {
        return "pasm/query";
    }


    /**
     * 根据客户身份证号来查询客户预授信结果
     */
    @ResponseBody
    @RequestMapping(value = {"/queryInfo"})
    public Clientquery queryInfo(@RequestParam String idCardNo, ModelMap map) {
        Clientquery clientquery = null;
        if (idCardNo != null) {
            clientquery = clientqueryService.queryInfo(idCardNo);
        }
        return clientquery;
    }

    /**
     * 首次查询客户预授信发起请求
     */
    @ResponseBody
    @RequestMapping(value = {"/queryFirst"})
    public Clientquery queryFirst(Clientquery clientquery, ModelMap map) {
        Clientquery query = new Clientquery();
        try {
            //01黑名单校验
            logger.info("blacklistService findByidCard param:{}", clientquery.getIdCardNo());
            List<Blacklist> byidCard = blacklistService.findByidCard(clientquery.getIdCardNo());
            logger.info("blacklistService findByidCard result:{}", byidCard);
            if (byidCard.size() > 0) {
                clientquery.setQueryTime(byidCard.get(0).getBlackTime());
                clientquery.setName(byidCard.get(0).getName());
                clientquery.setPhone(byidCard.get(0).getPhone());
                clientquery.setQueryResult("03");
                return clientquery;
            }
            //获取当前登陆用户id 即查询用户的门店号
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            logger.info("currentUser：" + user.getUserName() + ":queryClientqueryStart:{}" + clientquery);
            //密等性校验
            Date date = new Date();
            query = clientqueryService.queryInfo(clientquery.getIdCardNo());
            //首次查询，有限期30天校验
            if (query != null && (date.getTime() - query.getQueryTime().getTime()) / (24 * 60 * 60 * 1000) < 30) {
                logger.info("currentUser：{}" + user.getUserName() + ":queryClientqueryResult:{}" + query);
                return query;
            }
            //入参赋值
            clientquery.setBranchId(user.getId());
            clientquery.setQueryTime(date);
            clientquery.setApplicationNo(GenerationNumberUtils.getApplicationNo(date));
            query = clientqueryService.queryFirst(clientquery);
            logger.info("currentUser：" + user.getUserName() + ":queryFirstClientqueryResult:{}" + query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return query;
    }

}
