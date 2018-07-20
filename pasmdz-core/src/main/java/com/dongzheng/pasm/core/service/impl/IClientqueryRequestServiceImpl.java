package com.dongzheng.pasm.core.service.impl;

import com.dongzheng.pasm.core.dao.IClientqueryRequestDao;
import com.dongzheng.pasm.core.dao.IMessageDao;
import com.dongzheng.pasm.core.dao.support.IBaseDao;
import com.dongzheng.pasm.core.entity.ClientqueryRequest;
import com.dongzheng.pasm.core.entity.Message;
import com.dongzheng.pasm.core.service.IClientqueryRequestService;
import com.dongzheng.pasm.core.service.support.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:wangyang
 * @Description:
 * @since 2018/7/12 19:12
 * 8 @Modificd By:
 */
@Service
public class IClientqueryRequestServiceImpl extends BaseServiceImpl<ClientqueryRequest, Integer> implements IClientqueryRequestService {

    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    /*
     * 消息查询Dao
     * */
    @Autowired
    private IClientqueryRequestDao iClientqueryRequestDao;

    @Override
    public Integer queryTotal(Integer integer) {
        return iClientqueryRequestDao.queryTotal(integer);
    }

    @Override
    public List<Object> findAllByBranckId(PageRequest pageRequest, Integer id) {

        return iClientqueryRequestDao.queryInfo(id);
    }
    @Override
    public List<Object> findAllByBranckId( Integer id)
    {
        return iClientqueryRequestDao.queryInfo(id);
    }
    @Override
    public IBaseDao<ClientqueryRequest, Integer> getBaseDao() {
        return this.iClientqueryRequestDao;
    }
}
