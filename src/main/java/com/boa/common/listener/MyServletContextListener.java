package com.boa.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Copyright (C), 2012-2020 Duenboa
 * @Author: Duenboa
 * @Date: 2017/8/8 17:23
 * @Version: 1.0.0
 * :
 * @see
 */
@WebListener("myServletContextListener")
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("MyServletContextListener contextInitialized()");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("MyServletContextListener contextDestroyed()");
    }
}
