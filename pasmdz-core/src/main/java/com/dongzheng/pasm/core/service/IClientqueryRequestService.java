package com.dongzheng.pasm.core.service;

import com.dongzheng.pasm.core.entity.ClientqueryRequest;
import com.dongzheng.pasm.core.service.support.IBaseService;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author:wangyang
 * @Description:
 * @since 2018/7/12 19:11
 * 8 @Modificd By:
 */
public interface IClientqueryRequestService extends IBaseService<ClientqueryRequest, Integer> {
    /**
     * 查询全部
     * */
    Integer queryTotal(Integer integer);

    List<Object> findAllByBranckId(PageRequest pageRequest, Integer id);

    List<Object> findAllByBranckId( Integer id);
}
