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


/**
 * @author DuenBoa
 * @date 2017/10/29
 */
@Controller
@RequestMapping("manage/order")
public class OrderManagerController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderManagerController.class);

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("page")
    public Jsonp getMyOrderList(Page<TOrder> page) {
        try {
            LOG.info(String.format("==[getOrderPage] params: [page=%s]", page));
            return Jsonp.ok(orderService.page(page));

        } catch (IllegalArgumentException | IllegalStateException e) {
            LOG.error(e.getMessage());
            return Jsonp.err(e.getMessage());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Jsonp.err();
        }
    }


    @ResponseBody
    @RequestMapping("updateStatus")
    public Jsonp updateStatus(Long id, String state) {
        try {
            orderService.updateStatus(id, state);
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
    @RequestMapping("logicDelete")
    public Jsonp logicDelete(Long id) {
        try {
            orderService.logicDelete(id);
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
