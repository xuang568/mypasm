package com.dongzheng.pasm.core.service;


import com.dongzheng.pasm.core.entity.Blacklist;
import com.dongzheng.pasm.core.service.support.IBaseService;

import java.util.List;

public interface IBlacklistService extends IBaseService<Blacklist, Integer> {
    /**
     * 根据用户身份id查找黑名单用户信息
     *
     * @param idCard
     * @return
     */
    List<Blacklist> findByidCard(String idCard);


}
