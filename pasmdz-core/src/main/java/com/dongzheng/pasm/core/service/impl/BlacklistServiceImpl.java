package com.dongzheng.pasm.core.service.impl;

import com.dongzheng.pasm.core.dao.IBlacklistDao;
import com.dongzheng.pasm.core.dao.support.IBaseDao;
import com.dongzheng.pasm.core.entity.Blacklist;
import com.dongzheng.pasm.core.service.IBlacklistService;
import com.dongzheng.pasm.core.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlacklistServiceImpl extends BaseServiceImpl<Blacklist, Integer> implements
        IBlacklistService {

    @Autowired
    private IBlacklistDao blacklistDao;

    @Override
    public IBaseDao<Blacklist, Integer> getBaseDao() {
        return this.blacklistDao;
    }

    @Override
    public List<Blacklist> findByidCard(String idCard) {
        return blacklistDao.findByIdCard(idCard);
    }

}
