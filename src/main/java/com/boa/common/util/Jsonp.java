package com.boa.common.util;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Jsonp {

    public static final String callbackKey = "callback";
    private String callback = null;
    private Map jsonp;
    private boolean isMultipart = false;

    private Jsonp() {
        jsonp = new HashMap();
    }

    private Jsonp(String status, Object data, String detail) {
        jsonp = new HashMap();
        setStatus(status);
        setDetail(detail);
        setData(data);
    }

    public static Jsonp ok() {
        return newInstance("1", "", "请求数据成功");
    }

    public static Jsonp ok(Object data) {
        return newInstance("1", data, "请求数据成功");
    }

    public static Jsonp err() {
        return newInstance("0", "", "请求数据失败");
    }

    public static Jsonp err(String msg) {
        return newInstance("0", "", msg);
    }

    public static Jsonp err(String status, String msg) {
        return newInstance(status, "", msg);
    }

    public static Jsonp paramError() {
        return newInstance("0", "", "参数错误");
    }

    public static Jsonp paramError(String msg) {
        return newInstance("0", "", msg);
    }

    public static Jsonp newInstance(String status, Object data, String detail) {
        return new Jsonp(status, data, detail);
    }

    public Map getMap() {
        return jsonp;
    }

    public String getStatus() {
        return (String) jsonp.get("status");
    }

    public Jsonp setStatus(String status) {
        if (null == status)
            jsonp.put("status", "");
        else
            jsonp.put("status", status);
        return this;
    }

    public Object getData() {
        return jsonp.get("data");
    }

    /**
     * 设置 响应数据
     * 列表类型数据(list)会自动转换为分页类型的数据
     *
     * @param data
     * @return
     */
    public Jsonp setData(Object data) {
        if (data instanceof List) {
            jsonp.put("data", (List) data);
        } else {
            jsonp.put("data", data);
        }
        return this;
    }

    public String getCallback() {
        return callback;
    }

    public Jsonp setCallback(HttpServletRequest request) {

        isMultipart = (request instanceof MultipartHttpServletRequest);
        setCallback(request.getParameter(callbackKey));
        return this;
    }

    @JsonValue
    public Object jsonpValue() {
        if (callback == null) {
            setDefaultCallback();
        }
        JSONPObject result = new JSONPObject(callback, jsonp);

        if (isMultipart) {

            String script = JsonUtil.toJson(result);
            return new JsonString("<script>try{ " + script + " }catch(e){  top.postMessage('" + script + "'); }</script>");
        } else {
            return result;
        }
    }

    private void setDefaultCallback() {
        try {
            setCallback(WebUtil.getRequest());
        } catch (Exception e) {
            setCallback("");
        }
    }

    public Jsonp setCallback(String callback) {
        if (callback == null)
            callback = "";
        this.callback = callback;
        return this;
    }

    public String getDetail() {
        return (String) jsonp.get("detail");
    }

    public Jsonp setDetail(String message) {
        if (null == message)
            jsonp.put("detail", "");
        else
            jsonp.put("detail", message);
        return this;
    }

    public Jsonp Multipart(boolean isMultipart) {
        this.isMultipart = isMultipart;
        return this;
    }

    public boolean isMultipart() {
        return isMultipart;
    }

    public void setMultipart(boolean isMultipart) {
        this.isMultipart = isMultipart;
    }
}
