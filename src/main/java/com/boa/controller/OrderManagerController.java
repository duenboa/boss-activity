package com.boa.controller;

import com.alibaba.fastjson.JSON;
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
    public String getMyOrderList(Integer page, Integer rows, TOrder condition, HttpServletResponse response) {

        String nullMsg = "{\"total\":0 , \"rows\":[{},{}]}";
        try {
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            Page<TOrder> pageObj = new Page<>();
            if (rows != null) {
                pageObj.setPageSize(rows);
            }
            if (page != null) {
                pageObj.setPageNumber(page);
            }
            LOG.info(String.format("==[getOrderPage] params: [page=%s]", pageObj));
            Page<TOrder> result = orderService.page(pageObj, condition);
            //return Jsonp.ok(result.getData());

            String json = "{\"total\":" + result.getTotalSize() + " , \"rows\":" + JSON.toJSONString(result.getData()) + "}";
            return json;

            // return Jsonp.ok(result.getData());
        } catch (IllegalArgumentException | IllegalStateException e) {
            LOG.error(e.getMessage());
            return nullMsg;
            //return Jsonp.err(e.getMessage());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return nullMsg;
            // return Jsonp.err();
        }
    }


    @ResponseBody
    @RequestMapping("update")
    public Jsonp update(TOrder torder, HttpServletResponse response) {
        try {
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("text/html;charset=utf-8");
            orderService.updateStatus(torder);
            return Jsonp.ok("修改成功!");

        } catch (IllegalArgumentException | IllegalStateException e) {
            LOG.error(e.getMessage());
            return Jsonp.err(e.getMessage());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Jsonp.err("修改失败!");
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
