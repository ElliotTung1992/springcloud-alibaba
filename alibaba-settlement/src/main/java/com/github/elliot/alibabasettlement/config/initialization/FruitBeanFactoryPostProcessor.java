package com.github.elliot.alibabasettlement.config.initialization;

import com.github.elliot.alibabasettlement.domain.Fruit;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FruitBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] fruitNames = beanFactory.getBeanNamesForType(Fruit.class);
        for (String fruitName : fruitNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(fruitName);
            beanDefinition.getPropertyValues().add("name", "我跟你嘻嘻哈哈");
        }
    }
}
