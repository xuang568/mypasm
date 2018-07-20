package com.dongzheng.pasm.core.service;

import com.dongzheng.pasm.core.entity.Role;
import com.dongzheng.pasm.core.service.support.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * <p>
 * 角色服务类
 * </p>
 *
 * @author xa
 * @since 2018-6-28
 */
public interface IRoleService extends IBaseService<Role, Integer> {

    /**
     * 添加或者修改角色
     *
     * @param role
     */
    void saveOrUpdate(Role role);

    /**
     * 给角色分配资源
     *
     * @param id          角色ID
     * @param resourceIds 资源ids
     */
    void grant(Integer id, String[] resourceIds);

    /**
     * 根据关键字查询分页
     *
     * @param searchText
     * @param pageRequest
     * @return
     */
    Page<Role> findAllByLike(String searchText, PageRequest pageRequest);

    /**
     * 分页查询
     *
     * @param pageable
     */
    Page<Role> findByPage(Pageable pageable);
}
