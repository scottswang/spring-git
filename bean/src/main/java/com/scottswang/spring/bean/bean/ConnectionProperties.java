package com.scottswang.spring.bean.bean;

import lombok.Data;

@Data
public class ConnectionProperties {
    private String username;
    private String password;
    private String remoteAddress;
}
