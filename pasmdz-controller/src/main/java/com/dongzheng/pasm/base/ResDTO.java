package com.dongzheng.pasm.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author xua
 */
@Setter
@Getter
public class ResDTO<T> implements Serializable {

    private boolean success;
    private String code;
    private String message;
    private Object data;
}
