package com.github.elliot.alibabasettlement.config.initialization;


import com.github.elliot.alibabasettlement.domain.Pear;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FruitBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        if(!registry.containsBeanDefinition("pear")){
            BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Pear.class).getBeanDefinition();
            beanDefinition.getPropertyValues().add("name", "Bruce");
            registry.registerBeanDefinition("pear", beanDefinition);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
