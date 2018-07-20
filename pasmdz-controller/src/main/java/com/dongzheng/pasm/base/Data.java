package com.dongzheng.pasm.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
public class Data implements Serializable {

    Page list;
    int page;
    int size;
    int totalPage;
    int totalSize;

}
