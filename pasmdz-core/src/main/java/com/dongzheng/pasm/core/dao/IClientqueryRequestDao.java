package com.dongzheng.pasm.core.dao;

import com.dongzheng.pasm.core.dao.support.IBaseDao;
import com.dongzheng.pasm.core.entity.ClientqueryRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:wangyang
 * @Description:
 * @since 2018/7/12 19:01
 * 8 @Modificd By:
 */
@Repository
public interface IClientqueryRequestDao extends IBaseDao<ClientqueryRequest, Integer> {

    @Query(nativeQuery = true, value = "select count(1) from pasmdz.clientquery cq left join pasmdz.message msg on cq.application_no=msg.application_no where cq.branch_id= :branchId and query_result in('01','03') order by cq.create_time desc")
    Integer queryTotal(@Param("branchId") Integer branchId);


//    @Query(nativeQuery = true, value = "select cq.application_no,cq.name,cq.id_card_no,cq.query_time,cq.query_result,cq.branch_id from pasmdz.clientquery cq left join pasmdz.message msg on cq.application_no=msg.application_no and cq.branch_id= :branchId order by cq.create_time desc")
//    List<Object> queryInfo(@Param("branchId") Integer branchId);

    @Query(nativeQuery = true, value = "select cq.application_no,cq.name,cq.id_card_no,cq.query_time,cq.query_result,cq.branch_id,cq.phone from pasmdz.clientquery cq left join pasmdz.message msg on cq.application_no=msg.application_no where cq.branch_id= :branchId and query_result in('01','03') order by cq.create_time desc")
    List<Object> queryInfo(@Param("branchId") Integer branchId);
}