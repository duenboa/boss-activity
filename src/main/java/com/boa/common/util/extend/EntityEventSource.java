package com.boa.common.util.extend;

public class EntityEventSource {
    public enum triggerType{
        UNKNOWN, INSERT, UPDATE, DELETE, SELECT
    }

    private Object trigger;
    private triggerType triggerType;

    public EntityEventSource(Object trigger, EntityEventSource.triggerType triggerType) {
        this.trigger = trigger;
        this.triggerType = triggerType;
    }

    public Object getTrigger() {
        return trigger;
    }

    public EntityEventSource.triggerType getTriggerType() {
        return triggerType;
    }
}
