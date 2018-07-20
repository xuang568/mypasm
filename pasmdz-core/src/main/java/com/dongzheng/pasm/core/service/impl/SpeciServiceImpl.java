package com.dongzheng.pasm.core.service.impl;

import com.dongzheng.pasm.core.dao.SpeciRepository;
import com.dongzheng.pasm.core.entity.Clientquery;
import com.dongzheng.pasm.core.service.SpeciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;

/**
 * @author xua
 */
@Service
@Transactional
public class SpeciServiceImpl implements SpeciService{

    @Autowired
    private  SpeciRepository speciRepository;



    @Override
    public  Page<Clientquery> findByPageAndParams(final Clientquery param, int pageNumber, int pageSize) {

        //分页信息
        Pageable pageable = new PageRequest(pageNumber, pageSize);

        //查询条件构造
        Specification<Clientquery> spec = new Specification<Clientquery>() {

            @Override
            public Predicate toPredicate(Root<Clientquery> root, CriteriaQuery<?> query, CriteriaBuilder cb) {


                Path<String> idCardNo = root.get("idCardNo");

                Predicate p = cb.equal(idCardNo, param.getIdCardNo());

               // Predicate p = cb.and(p1, p2);

                return p;

            }

        };

        return speciRepository.findAll(spec, pageable);

    }

    @Override
    public Page<Clientquery> findByPage(Pageable pageable) {
        return speciRepository.findAll(pageable);
    }

}
