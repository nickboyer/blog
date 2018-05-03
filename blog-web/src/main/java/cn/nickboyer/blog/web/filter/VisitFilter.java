/*
 * Copyright 2014-2018 buyforyou.cn.
 * All rights reserved.
 */
package cn.nickboyer.blog.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Kang.Y
 * @since 1.8
 */
@Component
@WebFilter(urlPatterns = "/*")
public class VisitFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(VisitFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String ip = req.getHeader("ip");
        MDC.put("ip", ip);
        logger.debug("访问[" + req.getRequestURL() + "]");
        chain.doFilter(request, response);
        MDC.clear();
    }

    @Override
    public void destroy() {

    }
}
