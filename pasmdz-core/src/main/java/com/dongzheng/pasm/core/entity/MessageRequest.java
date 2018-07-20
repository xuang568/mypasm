package com.dongzheng.pasm.core.entity;

import com.dongzheng.pasm.core.entity.support.BaseEntity;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author:wangyang
 * @Description:
 * @since 2018/7/12 17:38
 * 8 @Modificd By:
 */
@Entity
@ToString
public class MessageRequest extends BaseEntity {

    private static final long serialVersionUID = -6185555328874195552L;
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

    @OneToOne
    private ClientqueryRequest clientqueryRequest;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

}
