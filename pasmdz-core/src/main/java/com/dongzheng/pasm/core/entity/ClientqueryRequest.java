package com.dongzheng.pasm.core.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dongzheng.pasm.core.entity.support.BaseEntity;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @author:wangyang
 * @Description:
 * @since 2018/7/12 17:35
 * 8 @Modificd By:
 */
@Entity
@ToString
public class ClientqueryRequest extends BaseEntity {

    private static final long serialVersionUID = 7299528223400754681L;
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
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date queryTime;
    /**
     * 查询结果
     */
    private String queryResult;

    /**
     * 门店id
     */
    private Integer branchId;

    @OneToOne
    private MessageRequest messageRequest;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getApplicationRole() {
        return applicationRole;
    }

    public void setApplicationRole(String applicationRole) {
        this.applicationRole = applicationRole;
    }

    public String getQueryReason() {
        return queryReason;
    }

    public void setQueryReason(String queryReason) {
        this.queryReason = queryReason;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(Date queryTime) {
        this.queryTime = queryTime;
    }

    public String getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(String queryResult) {
        this.queryResult = queryResult;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }
}
