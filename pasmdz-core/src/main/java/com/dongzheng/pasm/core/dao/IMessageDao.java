package com.dongzheng.pasm.core.dao;

import com.dongzheng.pasm.core.dao.support.IBaseDao;
import com.dongzheng.pasm.core.entity.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:wangyang
 * @Description:
 * @since 2018/7/12 10:59
 * 8 @Modificd By:
 */
@Repository
public interface IMessageDao extends IBaseDao<Message, Integer> {
    //查询所有消息
    @Query(nativeQuery = true,value = "select count(*) FROM pasmdz.message WHERE branch_id=:integer ")
    Integer queryTotal(@Param("integer") Integer integer);

    @Query(nativeQuery = true, value = "select * from pasmdz.message   where branch_id= :branchId  order by create_time desc")
    List<Message> findAllByBranckId(@Param("branchId") Integer branchId);
}
