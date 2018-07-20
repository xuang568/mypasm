package com.dongzheng.pasm.core.entity.support;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;


/**
 * <p>
 *
 * </p>
 *
 * @author xa
 * @since 2018-06-10
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -250118731239275742L;

}