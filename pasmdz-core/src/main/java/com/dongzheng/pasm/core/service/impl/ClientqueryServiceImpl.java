package com.dongzheng.pasm.core.service.impl;

import com.dongzheng.pasm.PcmuatIntegrationService;
import com.dongzheng.pasm.Req.PcmuatReqDTO;
import com.dongzheng.pasm.core.dao.IClientqueryDao;
import com.dongzheng.pasm.core.dao.support.IBaseDao;
import com.dongzheng.pasm.core.entity.Clientquery;
import com.dongzheng.pasm.core.service.IClientqueryService;
import com.dongzheng.pasm.core.service.support.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*
* 客户预授信查询服务接口
* */
@Service
public class ClientqueryServiceImpl extends BaseServiceImpl<Clientquery, Integer>
        implements IClientqueryService {

    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(ClientqueryServiceImpl.class);

    /*
    * 客户预授信查询Dao
    * */
    @Autowired
    private IClientqueryDao clientqueryDao;

    /*
    * 中科软 人行征信接口服务
    * */
    @Autowired
    private PcmuatIntegrationService pcmuatIntegrationService;

    @Override
    public IBaseDao<Clientquery, Integer> getBaseDao() {
        return this.clientqueryDao;
    }

    @Override
    public Page<Clientquery> findAllByLike(String searchText, PageRequest pageRequest) {
        if (StringUtils.isBlank(searchText)) {
            searchText = "";
        }
       return  clientqueryDao.findAllByNameContaining(searchText, pageRequest);
    }

    @Override
    public Clientquery queryInfo(String idCardNo) {
        return clientqueryDao.queeryInfo(idCardNo);
    }

    @Override
    public Integer queryTotal(Integer integer) {
        return clientqueryDao.queryTotal(integer);
    }

    @Override
    public Integer querySuccess(Integer integer) {
        return clientqueryDao.querySuccess(integer);
    }

    @Override
    public Integer queryFail(Integer integer) {
        return clientqueryDao.queryFail(integer);
    }

    @Override
    public Integer queryUnknown(Integer integer) {
        return clientqueryDao.queryUnknown(integer);
    }

    @Override
    public Clientquery queryFirst(Clientquery clientquery) {
      try {
          logger.info("call ClientqueryServiceImpl queryFirst:{}"+clientquery);
          //首次查询，创建查询记录
          if(clientquery!=null){
              PcmuatReqDTO pcmuatReqDTO=new PcmuatReqDTO();
              pcmuatReqDTO.setApplyNo(clientquery.getApplicationNo());
              pcmuatReqDTO.setOperator(String.valueOf(clientquery.getBranchId()));
              pcmuatReqDTO.setRequestDate(clientquery.getQueryTime());
              pcmuatReqDTO.setApplicationNumber(clientquery.getApplicationNo());
              pcmuatReqDTO.setApplicantName(clientquery.getName());
              pcmuatReqDTO.setApplicationRole(clientquery.getApplicationRole());
              pcmuatReqDTO.setIdCardType(clientquery.getIdCardType());
              pcmuatReqDTO.setIdCardNbr(clientquery.getIdCardNo());
              pcmuatReqDTO.setQueryReason(clientquery.getQueryReason());
              String pcmuatResult = pcmuatIntegrationService.queryPcmuat(pcmuatReqDTO);
              logger.info("ClientqueryServiceImpl queryFirst result:{}",pcmuatResult);
              if("True".equals(pcmuatResult)){
                  //查询结果变更为查询中
                  clientquery.setQueryResult("02");
                  clientquery.setApplicationNo("Br-A028883000");
                  //首次查询记录入库
                  Clientquery client = clientqueryDao.save(clientquery);
                  return client;
              }
              clientquery.setQueryResult("05");
              return clientquery;
          }
      }catch (Exception e){
          e.printStackTrace();
      }

        return null;
    }

    @Override
    public List<Clientquery> findAllByBranckId(PageRequest pageRequest, Integer id) {

        return clientqueryDao.findAllByBranckId(id);
    }


}
