package com.boa.common.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Copyright (C), 2012-2020 Duenboa
 * @Author: Duenboa
 * @Date: 2017/8/8 16:55
 * @Version: 1.0.0
 * :
 * @see
 */
@WebServlet(name="myServlet", urlPatterns = "*.do", loadOnStartup = 1)
public class MyServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("myServlet is worked :: doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        System.out.println("myServlet is worked :: doPost()");
    }
}
