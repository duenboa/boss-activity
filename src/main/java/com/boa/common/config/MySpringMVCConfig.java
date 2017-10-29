package com.boa.common.config;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ObjectToStringHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.MappedInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * @Copyright (C), 2000-9999 DuenBoa
 * @Author: DuenBoa on 2017/6/24 0:08
 * @Desc com.boa.common 自定义拦截器配置
 * @See
 */
@Configuration //配置申明
public class MySpringMVCConfig extends WebMvcConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MySpringMVCConfig.class);


    /** 将自定义拦截器添加到拦截器注册机中 **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        HandlerInterceptor handlerInterceptor = new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
                Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
                StringBuffer requestURL = httpServletRequest.getRequestURL();
                String paraStr = JSONObject.toJSONString(parameterMap);
                LOGGER.info("addInterceptors:: preHandle. RequestURL: {}, ParamsMap：{}", requestURL, paraStr);
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
                LOGGER.info("addInterceptors:: postHandle");
            }

            @Override
            public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
                LOGGER.info("addInterceptors:: afterCompletion");
            }
        };

        registry.addInterceptor(handlerInterceptor).addPathPatterns("/**"); //指定拦截规则
    }


    /**
     * 将自定义的消息转换器存入到容器管理的消息转换器中
     * 标准方法
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("utf-8"));
        converters.add(stringHttpMessageConverter);
        LOGGER.info("======= [org.springframework.http.converter.StringHttpMessageConverter.class] initialized ");
        ObjectToStringHttpMessageConverter objectToStringHttpMessageConverter = new ObjectToStringHttpMessageConverter(new GenericConversionService(), Charset.forName("utf-8"));
        converters.add(objectToStringHttpMessageConverter);
        LOGGER.info("======= [org.springframework.http.converter.ObjectToStringHttpMessageConverter.class] initialized");
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        converters.add(mappingJackson2HttpMessageConverter);
        LOGGER.info("======= [org.springframework.http.converter.json.MappingJackson2HttpMessageConverter.class] initialized");
    }


}
