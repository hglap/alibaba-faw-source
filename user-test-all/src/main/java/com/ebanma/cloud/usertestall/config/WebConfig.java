package com.ebanma.cloud.usertestall.config;

import com.ebanma.cloud.usertestall.interceptor.RateLimitInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 *
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private RateLimitInterceptor rateLimitInterceptor;

    /**
     * 将限流拦截器添加进来
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(rateLimitInterceptor).addPathPatterns("/api/**");
    }

    /**
     * 添加资源处理程序
     *
     * @param registry 注册表
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
