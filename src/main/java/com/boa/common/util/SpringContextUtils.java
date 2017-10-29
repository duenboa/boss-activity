package com.boa.common.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

@Lazy(false)
@Component("SpringContextUtils")
public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext context;
    private static boolean started=false;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.context=applicationContext;
        started = true;
    }

    public static boolean containsLocalBean(String name) {
        return context.containsLocalBean(name);
    }

    public static String getId() {
        return context.getId();
    }

    public static String getApplicationName() {
        return context.getApplicationName();
    }

    public static String getDisplayName() {
        return context.getDisplayName();
    }

    public static long getStartupDate() {
        return context.getStartupDate();
    }

    public static ApplicationContext getParent() {
        return context.getParent();
    }

    public static AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException {
        return context.getAutowireCapableBeanFactory();
    }

    public static Environment getEnvironment() {
        return context.getEnvironment();
    }

    public static boolean containsBeanDefinition(String beanName) {
        return context.containsBeanDefinition(beanName);
    }

    public static int getBeanDefinitionCount() {
        return context.getBeanDefinitionCount();
    }

    public static String[] getBeanDefinitionNames() {
        return context.getBeanDefinitionNames();
    }

    public static String[] getBeanNamesForType(Class<?> type) {
        return context.getBeanNamesForType(type);
    }

    public static String[] getBeanNamesForType(Class<?> type, boolean includeNonSingletons, boolean allowEagerInit) {
        return context.getBeanNamesForType(type, includeNonSingletons, allowEagerInit);
    }

    public static <T> Map<String,T> getBeansOfType(Class<T> type) throws BeansException {
        try{
            return context.getBeansOfType(type);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static <T> Map<String,T> getBeansOfType(Class<T> type, boolean includeNonSingletons, boolean allowEagerInit) throws BeansException {
        return context.getBeansOfType(type, includeNonSingletons, allowEagerInit);
    }

    public static String[] getBeanNamesForAnnotation(Class<? extends Annotation> annotationType) {
        return context.getBeanNamesForAnnotation(annotationType);
    }

    public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) throws BeansException {
        return context.getBeansWithAnnotation(annotationType);
    }

    public static <A extends Annotation> A findAnnotationOnBean(String beanName, Class<A> annotationType) throws NoSuchBeanDefinitionException {
        return context.findAnnotationOnBean(beanName, annotationType);
    }

    public static Object getBean(String name) throws BeansException {
        return context.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return context.getBean(name, requiredType);
    }

    public static <T> T getBean(Class<T> requiredType) throws BeansException {
        return context.getBean(requiredType);
    }

    public static Object getBean(String name, Object... args) throws BeansException {
        return context.getBean(name, args);
    }

    public static boolean containsBean(String name) {
        return context.containsBean(name);
    }

    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return context.isSingleton(name);
    }

    public static boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
        return context.isPrototype(name);
    }

    public static boolean isTypeMatch(String name, Class<?> targetType) throws NoSuchBeanDefinitionException {
        return context.isTypeMatch(name, targetType);
    }

    public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
        return context.getType(name);
    }

    public static String[] getAliases(String name) {
        return context.getAliases(name);
    }

    public static BeanFactory getParentBeanFactory() {
        return context.getParentBeanFactory();
    }

    public static String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        return context.getMessage(code, args, defaultMessage, locale);
    }

    public static String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        return context.getMessage(code, args, locale);
    }

    public static String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        return context.getMessage(resolvable, locale);
    }

    public static void publishEvent(ApplicationEvent event) {
        context.publishEvent(event);
    }

    public static Resource[] getResources(String locationPattern) throws IOException {
        return context.getResources(locationPattern);
    }

    public static Resource getResource(String location) {
        return context.getResource(location);
    }

    public static ApplicationContext getContext(){
        return context;
    }

    public static boolean isAvailable(){
        return started && null != context;
    }
}
