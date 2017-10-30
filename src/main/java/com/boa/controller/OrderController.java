package com.boa.controller;

import com.boa.common.util.Jsonp;
import com.boa.common.util.pagination.Page;
import com.boa.entity.TOrder;
import com.boa.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Duenboa
 */
@Controller
@RequestMapping("/activity/order")
public class OrderController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;


    @ResponseBody
    @RequestMapping("add")
    public Jsonp add(HttpServletResponse response, TOrder order) {
        try {
            response.addHeader("Access-Control-Allow-Origin", "*");
            //response.setContentType("application/json;charset=utf-8");
            return Jsonp.ok(orderService.save(order));

        } catch (IllegalArgumentException | IllegalStateException e) {
            LOG.error(e.getMessage());
            return Jsonp.err(e.getMessage());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Jsonp.err();
        }
    }
}
