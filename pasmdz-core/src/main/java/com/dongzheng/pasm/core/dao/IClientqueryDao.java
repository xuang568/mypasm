package com.dongzheng.pasm.core.dao;

import com.dongzheng.pasm.core.dao.support.IBaseDao;
import com.dongzheng.pasm.core.entity.Clientquery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
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
public interface IClientqueryDao extends IBaseDao<Clientquery, Integer> {

    Page<Clientquery> findAllByNameContaining(String searchText, Pageable pageable);

    @Query(nativeQuery = true,value = "select * FROM clientquery WHERE id_card_no = :idCardNo")
    Clientquery queeryInfo(@Param("idCardNo") String idCardNo);

    //查询所有有限期内的查询用户数
    @Query(nativeQuery = true,value = "select count(*) FROM clientquery WHERE branch_id=:integer and query_result !=04")
    Integer queryTotal(@Param("integer") Integer integer);

    //查询所有有限期内的通过的用户数
    @Query(nativeQuery = true,value = "select count(*) FROM clientquery WHERE branch_id=:integer and query_result = 01")
    Integer querySuccess(@Param("integer") Integer integer);

    //查询所有有限期内的未通过的用户数
    @Query(nativeQuery = true,value = "select count(*) FROM clientquery WHERE branch_id=:integer and query_result = 03")
    Integer queryFail(@Param("integer") Integer integer);

    //查询所有有限期内的查询中的用户数
    @Query(nativeQuery = true,value = "select count(*) FROM clientquery WHERE branch_id=:integer and query_result = 05")
    Integer queryUnknown(@Param("integer") Integer integer);

    @Query(nativeQuery = true, value = "select * FROM clientquery WHERE branch_id = :branchId order by query_time desc")
    List<Clientquery> findAllByBranckId(@Param("branchId") Integer branchId);
}
