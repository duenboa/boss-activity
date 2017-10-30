package com.boa.common.filter;

import com.boa.common.util.JsonUtil;
import com.boa.common.util.Jsonp;
import com.boa.controller.LoginController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// TODO: 2017/10/29完成权限过滤+查询分页页面

/**
 * @author DuenBoa
 * @date 2017/10/29
 */
@WebFilter(urlPatterns = "/manage/*/*", filterName = "loginFilter")
public class LoginFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(LoginFilter.class);

    private static final String JSESSIONID_NAME = "JSESSIONID";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        servletResponse.setCharacterEncoding("UTF-8");
        LOG.debug("LoginFilter doFilter()...");
        try {
            Cookie[] cookies = request.getCookies();
            String sessionInCC = null;
            if (cookies != null && cookies.length > 0) {
                for (int i = 0; i < cookies.length; i++) {
                    Cookie cookie = cookies[i];
                    if (JSESSIONID_NAME.equals(cookie.getName())) {
                        sessionInCC = cookie.getValue();
                        break;
                    }
                }
            }
            if (sessionInCC == null) {
                Jsonp baseResponse = Jsonp.err("-99", "请登录");
                servletResponse.getWriter().write(request.getParameter("callback") + JsonUtil.toJson(baseResponse));
                return;
            }

            HttpSession session = request.getSession();
            if (!session.getId().equals(sessionInCC) || session.getAttribute(LoginController.USER_INFO_SESSION_KEY) == null) {
                Jsonp baseResponse = Jsonp.err("-99", "请登录.");
                servletResponse.getWriter().write(request.getParameter("callback") + JsonUtil.toJson(baseResponse));
                return;
            }

        } catch (Exception e) {
            Jsonp baseResponse = Jsonp.err("-99", "请登录..");
            servletResponse.getWriter().write(request.getParameter("callback") + JsonUtil.toJson(baseResponse));
            return;
        }
        //放行
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
