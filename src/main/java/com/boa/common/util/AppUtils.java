package com.boa.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;


/**
 * @Copyright (C), 2012-2020 上海好屋网信息技术有限公司
 * @Author: DengBenbo 20160289
 * @Date: 2017/6/22
 * @Version: 1.0.0
 * :
 * @see
 */
@Component("appUtils")
public class AppUtils implements ApplicationContextAware, ServletContextAware, ResourceLoaderAware, BeanFactoryAware, BeanPostProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppUtils.class);
    private static BeanFactory beanFactory;
    private static ApplicationContext applicationContext;
    private static ResourceLoader resourceLoader;
    private static ServletContext servletContext;

    /**
     * @param bean     the new bean instance
     * @param beanName the name of the bean
     * @return the bean instance to use, either the original or a wrapped one; if
     * {@code null}, no subsequent BeanPostProcessors will be invoked
     * @throws BeansException in case of errors
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
     * @see org.springframework.beans.factory.FactoryBean
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //LOGGER.info("=================== After init [{}]: {}  completed !", bean.getClass().getName(), beanName);
        return bean;
    }

    /**
     * @param bean     the new bean instance
     * @param beanName the name of the bean
     * @return the bean instance to use, either the original or a wrapped one; if
     * {@code null}, no subsequent BeanPostProcessors will be invoked
     * @throws BeansException in case of errors
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //LOGGER.info("=================== Before init [{}]: {} completed ! ", bean.getClass().getName(), beanName);
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        LOGGER.info("=================== init AppUtils.beanFactory  completed! ");
        AppUtils.beanFactory = beanFactory;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LOGGER.info("=================== init AppUtils.applicationContext  completed!  ");
        AppUtils.applicationContext = applicationContext;
    }

    /**
     * Set the ResourceLoader that this object runs in.
     *
     * @param resourceLoader ResourceLoader object to be used by this object
     * @see org.springframework.core.io.support.ResourcePatternResolver
     * @see org.springframework.core.io.support.ResourcePatternUtils#getResourcePatternResolver
     */
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        LOGGER.info("=================== init AppUtils.resourceLoader  completed!  ");
        AppUtils.resourceLoader = resourceLoader;
    }

    /**
     * Set the {@link ServletContext} that this object runs in.
     *
     * @param servletContext ServletContext object to be used by this object
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
     * @see ApplicationContextAware#setApplicationContext
     */
    @Override
    public void setServletContext(ServletContext servletContext) {
        LOGGER.info("=================== init AppUtils.servletContext  completed!  ");
        AppUtils.servletContext = servletContext;
    }

    public static BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    public static ServletContext getServletContext() {
        return servletContext;
    }

    public static <T> T getBean(Class<T> clz) {
        return beanFactory.getBean(clz);
    }


    public static <T> T getBean(String beanId, Class<T> clz) {
        return beanFactory.getBean(beanId, clz);
    }
}
