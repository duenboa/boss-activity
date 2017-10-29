package com.boa.common.util;

public interface EntityListener<T> extends java.util.EventListener{

    void beforeChange(EntityEvent<T> event);

    void afterChange(EntityEvent<T> event);

    int getOrder();
}
