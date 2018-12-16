package com.scottswang.spring.bean.bean;

import lombok.Data;

@Data
public class OtherBean {
    private String name;

    public OtherBean(String name) {
        this.name = name;
    }
}
