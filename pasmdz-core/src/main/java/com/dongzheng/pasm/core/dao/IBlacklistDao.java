package com.dongzheng.pasm.core.dao;

import com.dongzheng.pasm.core.dao.support.IBaseDao;
import com.dongzheng.pasm.core.entity.Blacklist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author xa
 * @since 2018-06-10
 */
@Repository
public interface IBlacklistDao extends IBaseDao<Blacklist, Integer> {

    @Query(nativeQuery = true,value = "select * FROM blacklist WHERE id_card = :idCard")
    List<Blacklist> findByIdCard(@Param("idCard") String idCard);
}
