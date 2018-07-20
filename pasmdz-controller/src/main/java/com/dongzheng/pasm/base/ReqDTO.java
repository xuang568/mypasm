package com.dongzheng.pasm.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author xua
 */
@Setter
@Getter
public class ReqDTO<T> implements Serializable {

    private boolean success;
    private String code;
    private String message;
    private Object data;

}
