package com.dongzheng.pasm.core.dao;

import com.dongzheng.pasm.core.dao.support.IBaseDao;
import com.dongzheng.pasm.core.entity.Clientquery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *
 * </p>
 *
 * @author xa
 * @since 2018-06-10
 */
@Repository
public interface SpeciRepository extends IBaseDao<Clientquery, Integer>{
    @Override
    Page<Clientquery> findAll(Specification<Clientquery> spec, Pageable pageable);
}
