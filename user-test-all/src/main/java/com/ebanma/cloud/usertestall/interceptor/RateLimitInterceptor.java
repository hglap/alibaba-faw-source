package com.ebanma.cloud.usertestall.interceptor;

import com.ebanma.cloud.usertestall.domain.common.ErrorCode;
import com.ebanma.cloud.usertestall.exception.BusinessException;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 限流拦截器，pom中需要引入 Guava支持
 */
@Component
public class RateLimitInterceptor implements HandlerInterceptor {

    /**
     * 速度限制器（QPS限制为 1,即 1秒内的请求数为 1）
     */
    private static final RateLimiter rateLimiter = RateLimiter.create(1);

    private static final Logger LOGGER = LoggerFactory.getLogger(RateLimitInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 尝试获取令牌，若没有获取到，则被限流了
        if (!rateLimiter.tryAcquire()) {
            LOGGER.error("系统已被限流了！");

            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return true;
    }
}
