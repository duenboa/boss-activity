package com.boa.controller;

import com.boa.common.util.Jsonp;
import com.boa.entity.TAdmin;
import com.boa.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author DuenBoa
 * @date 2017/10/28
 */
@Controller
@RequestMapping("sys")
public class LoginController {

    public static final String USER_INFO_SESSION_KEY = "UI_1";
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;

    @ResponseBody
    @RequestMapping(value = "login") //, method = RequestMethod.POST
    public Jsonp login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        try {
            LOG.info(String.format("==[login] params: [username=%s], [password=%s]", username, password));
            response.addHeader("Access-Control-Allow-Origin", "*");
            TAdmin admin = loginService.login(username, password);
            HttpSession session = request.getSession();
            session.setAttribute(USER_INFO_SESSION_KEY, admin);
            return Jsonp.ok();

        } catch (IllegalArgumentException | IllegalStateException e) {
            LOG.error(e.getMessage());
            return Jsonp.err(e.getMessage());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Jsonp.err();
        }
    }

    @ResponseBody
    @RequestMapping(value = "logout")
    public Jsonp logout(HttpServletRequest request, HttpServletResponse response) {
        try {
            LOG.info(String.format("==[logout]"));
            response.addHeader("Access-Control-Allow-Origin", "*");
            HttpSession session = request.getSession();
            session.removeAttribute(USER_INFO_SESSION_KEY);
            session.invalidate();
            return Jsonp.ok();

        } catch (IllegalArgumentException | IllegalStateException e) {
            LOG.error(e.getMessage());
            return Jsonp.err(e.getMessage());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Jsonp.err();
        }
    }

}
