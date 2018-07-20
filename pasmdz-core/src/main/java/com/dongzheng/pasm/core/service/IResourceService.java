package com.dongzheng.pasm.core.service;

import com.dongzheng.pasm.core.entity.Resource;
import com.dongzheng.pasm.core.service.support.IBaseService;
import com.dongzheng.pasm.core.vo.ZtreeView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * <p>
 * 资源服务类
 * </p>
 *
 * @author xa
 * @since 2018-6-28
 */
public interface IResourceService extends IBaseService<Resource, Integer> {

    /**
     * 获取角色的权限树
     *
     * @param roleId
     * @return
     */
    List<ZtreeView> tree(int roleId);

    /**
     * 修改或者新增资源
     *
     * @param resource
     */
    void saveOrUpdate(Resource resource);

    /**
     * 关键字分页
     *
     * @param searchText
     * @param pageRequest
     * @return
     */
    Page<Resource> findAllByLike(String searchText, PageRequest pageRequest);

    /**
     * 分页查询
     *
     * @param pageable
     */
    Page<Resource> findByPage(Pageable pageable);
}
