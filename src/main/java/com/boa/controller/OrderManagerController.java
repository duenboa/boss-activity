package com.boa.controller;

import com.alibaba.fastjson.JSONArray;
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
 * @author DuenBoa
 * @date 2017/10/29
 */
@Controller
@RequestMapping("manage/order")
public class OrderManagerController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderManagerController.class);

    @Autowired
    private OrderService orderService;

    /**
     * 查询分页列表数据
     *
     * @param page
     * @param rows
     * @param condition 只有phone可以作为查询条件.
     * @param response
     */
    @ResponseBody
    @RequestMapping("page")
    public void getMyOrderList(int page, int rows, TOrder condition, HttpServletResponse response) {
        try {
            Page<TOrder> pageObj = new Page<>();
            pageObj.setPageSize(rows);
            pageObj.setPageNumber(page);
            LOG.info(String.format("==[getOrderPage] params: [page=%s]", pageObj));
            response.addHeader("Access-Control-Allow-Origin", "*");
            Page<TOrder> result = orderService.page(pageObj, condition);
            //return Jsonp.ok(result.getData());

            response.setContentType("text/html;charset=utf-8");
            //{"total":10 , "rows":[{},{}]}
            String json = "{\"total\":" + result.getTotalSize() + " , \"rows\":" + JSONArray.toJSONString(result.getData()) + "}";
            response.getWriter().write(json);

            // return Jsonp.ok(result.getData());
        } catch (IllegalArgumentException | IllegalStateException e) {
            LOG.error(e.getMessage());
            //return Jsonp.err(e.getMessage());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            // return Jsonp.err();
        }
    }


    @ResponseBody
    @RequestMapping("updateStatus")
    public Jsonp updateStatus(Long id, String state, HttpServletResponse response) {
        try {
            response.addHeader("Access-Control-Allow-Origin", "*");
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
    public Jsonp logicDelete(Long id, HttpServletResponse response) {
        try {
            response.addHeader("Access-Control-Allow-Origin", "*");
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
