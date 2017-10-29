package com.boa.common.util.extend;

import java.util.Comparator;

public class EntityListenerComparator implements Comparator<EntityListener> {

    @Override
    public int compare(EntityListener o1, EntityListener o2) {
        if( null == o1 || null == o2){
            return 0;
        }
        return Integer.compare(o1.getOrder(),o2.getOrder());
    }
}
