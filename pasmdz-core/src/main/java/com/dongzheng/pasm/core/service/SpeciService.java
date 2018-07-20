package com.dongzheng.pasm.core.service;

import com.dongzheng.pasm.core.entity.Clientquery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author xua
 */
public interface SpeciService {

    public Page<Clientquery> findByPageAndParams(final Clientquery param, int pageNumber, int pageSize);


    Page<Clientquery> findByPage(Pageable pageable);
}

