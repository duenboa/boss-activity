package com.boa.common.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Copyright (C), 2000-9999 DuenBoa
 * @Author: DuenBoa on 2017/6/25 17:20
 * @Desc com.boa.common.factorybean
 * @See
 */
public class MyFactoryBean<T> implements FactoryBean<T> {

    @Override
    public T getObject() throws Exception {
        return null;
    }


    @Override
    public Class<?> getObjectType() {
        return null;
    }


    @Override
    public boolean isSingleton() {
        return false;
    }
}
