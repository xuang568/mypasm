package com.dongzheng.pasm.Req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

@Repository
@ToString
@Getter
@Setter
public class BaseReqDTO implements Serializable {

    private static final long serialVersionUID = 1971910832944028275L;

    /**
     * 批次号
     */
    private String applyNo;

    /**
     * 请求时间
     */
    private Date requestDate;

    /**
     * 操作人
     */
    private String operator;



}
