package com.github.elliot.alibabasettlement;

import com.github.elliot.alibabasettlement.domain.Apple;
import com.github.elliot.alibabasettlement.domain.Pear;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class AlibabaSettlementApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AlibabaSettlementApplication.class, args);

        // get apple
        Apple apple = (Apple) context.getBean("Apple");
        System.out.println(apple);

        // get pear
        Pear pear = (Pear) context.getBean("pear");
        System.out.println(pear);
    }

}
