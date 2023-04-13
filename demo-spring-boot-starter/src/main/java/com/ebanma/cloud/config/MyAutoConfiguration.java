package com.ebanma.cloud.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 黄贵龙
 * @version $ Id: MyAutoConfiguration, v 0.1 2023/04/13 21:58 86139 Exp $
 */
@Configuration
@ConditionalOnBean(ConfigMarker.class)
public class MyAutoConfiguration {

    static {
        System.out.println("MyAutoConfiguration init....");
    }

    @Bean
    public SimpleBean simpleBean(){
        return new SimpleBean();
    }
}
