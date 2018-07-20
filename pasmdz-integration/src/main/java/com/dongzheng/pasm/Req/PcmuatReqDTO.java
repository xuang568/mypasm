package com.dongzheng.pasm.Req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;

@Repository
@ToString
@Getter
@Setter
public class PcmuatReqDTO extends BaseReqDTO {

    /**
     * 申请号
     */
    private String applicationNumber;

    /**
     * 姓名
     */
    private String applicantName;

    /**
     * 证件类型
     */
    private String idCardType;

    /**
     * 证件号
     */
    private String idCardNbr;

    /**
     * 申请人角色
     */
    private String applicationRole;

    /**
     * 查询原因
     */
    private String queryReason;



}
