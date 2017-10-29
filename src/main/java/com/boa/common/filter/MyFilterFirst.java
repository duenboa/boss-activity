package com.boa.common.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
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

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("myFilterFirst init()...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("myFilterFirst doFilter()...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("myFilterFirst destroy()...");
    }
}
