package com.ebanma.cloud.usertestall.filter;

import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 黄贵龙
 * @version $ Id: TraceIdFilter, v 0.1 2023/03/26 21:12 86139 Exp $
 */
@WebFilter(urlPatterns = "/*")
@Order(1)
public class TraceIdFilter implements Filter {

    private static final String TRACE_ID = "traceId";

    /**
     * 打印的日志中增加 信息
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 尝试从请求信息中获取TraceId信息
        String traceId = request.getParameter(TRACE_ID);

        // 如果为空，则生成一个。
        if (StringUtils.isEmpty(traceId)) {
            traceId = UUID.randomUUID().toString();
        }

        // 借助slf4j的方法，将其放到日志中
        MDC.put(TRACE_ID, traceId);

        // 将过滤器链继续下去
        chain.doFilter(request, response);
    }
}