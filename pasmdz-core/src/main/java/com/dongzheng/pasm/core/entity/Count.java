package com.dongzheng.pasm.core.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author xa
 * @since 2018-06-12
 */
@Repository
@ToString
@Setter
@Getter
public class Count implements Serializable {
    private static final long serialVersionUID = -6839673970963489122L;


    /**
     * 预授信总人数

     */
    private Integer total;

    /**
     * 预授信通过人数
     */
    private Integer success;

    /**
     * 预授信未通过人数
     */
    private Integer fail ;

    /**
     * 预授信结果未知人数
     */
    private Integer querying;

    /**
     * 预授信通过率
     */
    private Double rate;


    public Count() {
    }

    public Count(Integer total, Integer success, Integer fail, Integer querying, double v) {
        this.total=total;
        this.success=success;
        this.fail=fail;
        this.querying=querying;
        this.rate=v;
    }
}
