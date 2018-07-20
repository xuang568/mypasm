package com.dongzheng.pasm.core.entity;

import com.dongzheng.pasm.core.entity.support.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author:wangyang
 * @Description:
 * @since 2018/7/12 10:37
 * 8 @Modificd By:
 */
@Entity
@ToString
@Setter
@Getter
public class Message  extends BaseEntity {
    private static final long serialVersionUID = 6234443491137600913L;
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     *申请编号
     * */
    private String applicationNo;

    /**
     * 门店id
     */
    private Integer branchId;

    /**
     * 证件号
     */
    private String idCardNo;
}
