package com.github.elliot.alibabasettlement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleFactoryBeanConfiguration {

    @Bean
    public SimpleFactoryBean simpleFactoryBean(){
        return new SimpleFactoryBean();
    }

    @Bean
    public TestConfiguration testConfiguration(SimpleFactoryBean simpleFactoryBean) throws Exception {
        return simpleFactoryBean.getObject();
    }
}
