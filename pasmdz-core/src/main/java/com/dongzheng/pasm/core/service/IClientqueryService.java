package com.dongzheng.pasm.core.service;

import com.dongzheng.pasm.core.entity.Clientquery;
import com.dongzheng.pasm.core.service.support.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IClientqueryService extends IBaseService<Clientquery, Integer> {

    /**
     * 根据关键字查询分页
     *
     * @param searchText
     * @param pageRequest
     * @return
     */
    Page<Clientquery> findAllByLike(String searchText, PageRequest pageRequest);

    /**
     * 新增一条预授信查询记录
     *
     * @param
     * @param
     * @return
     */
    @Override
    void save(Clientquery clientquery);

    /**
     * 更新预授信查询记录结果 （通过后者不通过）
     *
     * @param
     * @param
     * @return
     */
    @Override
    Clientquery update(Clientquery clientquery);

    /**
     * 根据身份证号查询预查询结果
     *
     * @param idCardNo
     * @param
     * @return
     */
    Clientquery  queryInfo(String idCardNo);

    /**
    * 查询全部
    * */
    Integer queryTotal(Integer integer);

    /**
     * 查询通过
     */
    Integer querySuccess(Integer integer);

    /**
     * 查询未通过
     */
    Integer queryFail(Integer integer);

    /**
     * 查询结果未知
     * */
    Integer queryUnknown(Integer integer);

    /**
     * 首次发起查询预授信
     * */
    Clientquery queryFirst(Clientquery clientquery);


    List<Clientquery> findAllByBranckId(PageRequest pageRequest, Integer id);
}
