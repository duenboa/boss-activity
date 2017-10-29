package com.boa.common.util;

public class EntityEvent<T> extends java.util.EventObject{

    public enum TriggerType{
        UNKNOWN, INSERT, UPDATE, DELETE, SELECT
    }

    private TriggerType triggerType;


    public EntityEvent(T source,TriggerType triggerType) {
        super(source);
        this.triggerType= triggerType;
    }

    public TriggerType getTriggerType() {
        return triggerType;
    }

    @Override
    public T getSource() {
        return (T)super.getSource();
    }
}
