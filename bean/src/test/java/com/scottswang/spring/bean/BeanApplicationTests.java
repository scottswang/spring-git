package com.scottswang.spring.bean;

import com.scottswang.spring.bean.bean.OtherBean;
import com.scottswang.spring.bean.bean.ConnectionsProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanApplicationTests {

    @Autowired
    ConnectionsProperties connectionsProperties;


    @Autowired(required=false)
    @Qualifier("otherBean")
    OtherBean otherBean;

    @Autowired(required=false)
    @Qualifier("otherBean1")
    OtherBean otherBean1;

    @Autowired(required=false)
    @Qualifier("otherBean2")
    OtherBean otherBean2;
    
    @Autowired
    BeanFactory beanFactory;

    @Test
    public void checkConnectionsProperties() {
        log.info("connMap.size={}",connectionsProperties.getConnections().size());
        connectionsProperties.getConnections().values().forEach(value-> log.info(value.toString()));
    }

    @Test
    public void checkOtherBean() {
        if(null!=otherBean){
            log.info("otherBean.name={}",otherBean.getName());
        }else{
            log.info("otherBean is null");
        }
    }

    @Test
    public void checkOtherBean1() {
        if(null!=otherBean1){
            log.info("otherBean1.name={}",otherBean1.getName());
        }else{
            log.info("otherBean1 is null");
        }
    }

    @Test
    public void checkOtherBean2() {
        if(null!=otherBean2){
            log.info("otherBean2.name={}",otherBean2.getName());
        }else{
            log.info("otherBean2 is null");
        }
    }

    @Test
    public void printBean() {
        //OtherBean beans = beanFactory.getBean(OtherBean.class);
    }
}

