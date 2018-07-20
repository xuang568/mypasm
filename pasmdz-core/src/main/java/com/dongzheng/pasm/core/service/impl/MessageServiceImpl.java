package com.dongzheng.pasm.core.service.impl;

import com.dongzheng.pasm.core.common.utils.HibernateUtils;
import com.dongzheng.pasm.core.dao.IMessageDao;
import com.dongzheng.pasm.core.dao.support.IBaseDao;
import com.dongzheng.pasm.core.entity.Message;
import com.dongzheng.pasm.core.service.IMessageService;
import com.dongzheng.pasm.core.service.support.impl.BaseServiceImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author:wangyang
 * @Description:
 * @since 2018/7/12 10:56
 * 8 @Modificd By:
 */
@Service
public class MessageServiceImpl extends BaseServiceImpl<Message, Integer> implements IMessageService {
    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    /*
     * 消息查询Dao
     * */
    @Autowired
    private IMessageDao messageDao;

    @Override
    public Integer queryTotal(Integer integer) {
        return messageDao.queryTotal(integer);
    }

    @Override
    public List<Message> findAllByBranckId(PageRequest pageRequest, Integer id) {

        return messageDao.findAllByBranckId(id);
    }

    @Override
    public IBaseDao<Message, Integer> getBaseDao() {
        return this.messageDao;
    }

    @Override
    public Boolean batchInsert(List<Object> msgList) {
        Session session = HibernateUtils.getSession();
        try {
            Transaction tx = session.beginTransaction(); //注意用的是hibernate事务处理边界
            for (Object obj : msgList) {
                Object[] objs = (Object[]) obj;
                Message msg = new Message();
                msg.setApplicationNo((String) objs[0]);
                msg.setIdCardNo((String) objs[2]);
                msg.setBranchId((Integer) objs[5]);
                session.save(msg);
                if (objs.length % 50 == 0) // 以每50个数据作为一个处理单元
                {
                    session.flush();
                    session.clear();
                }
            }
            return true;
        } catch (Exception e) {
            logger.warn("批量插入出现异常：" + e);
        } finally {
            if (session != null) {
                session.clear();
                session.close();
            }
        }
        return false;
    }
}