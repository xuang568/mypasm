package com.dongzheng.pasm.core.dao;

import com.dongzheng.pasm.core.dao.support.IBaseDao;
import com.dongzheng.pasm.core.entity.CrawlerRequest;
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
public interface CrawlerRequestDao extends IBaseDao<CrawlerRequest, Integer> {


    @Query(nativeQuery = true,value = "SELECT a.cercode, b.LATEST24STATE FROM crawler_request a JOIN r_nr_latest24monthpaymentstate b ON b.REPORT_ID = a.report_id WHERE a.cercode =:idCard ")
    List<Object> queryInfo(@Param("idCard") String idCard);
}
