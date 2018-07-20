package com.dongzheng.pasm.core.service;

import com.dongzheng.pasm.core.entity.ClientqueryRequest;
import com.dongzheng.pasm.core.entity.Message;
import com.dongzheng.pasm.core.service.support.IBaseService;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author:wangyang
 * @Description:
 * @since 2018/7/12 10:54
 * 8 @Modificd By:
 */
public interface IMessageService extends IBaseService<Message, Integer> {
    /**
     * 查询全部
     * */
    Integer queryTotal(Integer integer);

    List<Message> findAllByBranckId(PageRequest pageRequest, Integer id);

    Boolean batchInsert(List<Object> msgList);
}
