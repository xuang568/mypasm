package com.dongzheng.pasm.core.entity;

import com.dongzheng.pasm.core.entity.support.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author xa
 * @since 2018-06-12
 */
@Entity
@ToString
@Setter
@Getter
public class Clientquery extends BaseEntity {


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
     * 姓名
     */
    private String name;

    /**
     * 身份证类型
     */
    private String idCardType;

    /**
     * 身份证号
     */
    private String idCardNo;

    /**
     * 申请角色
     */
    private String applicationRole;

    /**
     * 查询原因
     */
    private String queryReason;

    /**
     * 手机号码
     */
    private String phone;
    /**
     * 查询时间
     */
    private Date queryTime;
    /**
     * 查询结果
     */
    private String queryResult;

    /**
     * 门店id
     */
    private Integer branchId;

}
