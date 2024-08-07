package com.github.elliot.alibabasettlement.config;

import org.springframework.beans.factory.FactoryBean;

public class SimpleFactoryBean implements FactoryBean<TestConfiguration> {

    @Override
    public TestConfiguration getObject() throws Exception {
        return new TestConfiguration();
    }

    @Override
    public Class<?> getObjectType() {
        return TestConfiguration.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
