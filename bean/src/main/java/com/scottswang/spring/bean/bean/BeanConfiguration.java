package com.scottswang.spring.bean.bean;

import com.scottswang.spring.bean.Services.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 根据条件初始化bean
 */

@Slf4j
@Configuration
@EnableConfigurationProperties(ConnectionsProperties.class)//作用等同tag: b1
@ConditionalOnClass({ConnectionFactory.class})//如果删除了这个类文件,bean不会创建
@ConditionalOnProperty("init-bean")
public class BeanConfiguration {
    //tag: b1
    @ConditionalOnMissingBean
    @Bean
    public ConnectionsProperties connectionsProperties(){
       log.info("create  ConnectionsProperties");
       return new ConnectionsProperties();
    }

    //tag: f1
    @Bean
    public ConnectionFactory connectionFactory(){
        log.info("create ConnectionFactory");
        return new ConnectionFactory(){};
    }

    @ConditionalOnBean(ConnectionFactory.class)//tag: f1创建对象后 bean可以实例化
    @Bean("otherBean")
    public OtherBean otherBean(){
        log.info("create OtherBean");
        return new OtherBean("other");
    }

    @ConditionalOnMissingBean(ConnectionFactory.class)//tag: f1不创建对象后 bean可以实例化
    @Bean("otherBean1")
    public OtherBean otherBean1(){
        log.info("create OtherBean1");
        return new OtherBean("other1");
    }

    @ConditionalOnMissingBean//容器里没有OtherBean的实例才初始化
    @Bean("otherBean2")
    public OtherBean otherBean2(){
        log.info("create OtherBean2");
        return new OtherBean("other2");
    }

}
