package com.scottswang.spring.bean.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;


import java.util.HashMap;
import java.util.Map;

@Data
@ConfigurationProperties("bean")
public class ConnectionsProperties {

    @NestedConfigurationProperty
    Map<String, ConnectionProperties> connections = new HashMap<>();
}
