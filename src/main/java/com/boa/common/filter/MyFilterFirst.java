package com.boa.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Copyright (C), 2012-2020 Duenboa
 * @Author: Duenboa
 * @Date: 2017/8/8 16:57
 * @Version: 1.0.0
 * :
 * @see
 */
@WebFilter(filterName = "myFilterFirst", urlPatterns = "*.do")
public class MyFilterFirst implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(MyFilterFirst.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.debug("myFilterFirst init()...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOG.debug("myFilterFirst doFilter()...");
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        filterChain.doFilter(servletRequest, response);
    }

    @Override
    public void destroy() {
        LOG.debug("myFilterFirst destroy()...");
    }
}
