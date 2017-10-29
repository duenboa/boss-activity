package com.boa.common.util;

import java.io.Serializable;

public class CurrentUserHelp {

    private static ThreadLocal<Serializable> UID = new ThreadLocal<Serializable>() {};
    private static ICurrentUser delegate;

    public static void setCurrentUserID(Serializable userID){
        UID.set(userID);
    }

    public static Serializable getCurrentUserID(){

        if( null != delegate && null != delegate.getCurrentUserID()){
            return delegate.getCurrentUserID();
        }
        return CurrentUserHelp.UID.get();
    }

    public static ICurrentUser getDelegate() {
        return delegate;
    }

    public static void setDelegate(ICurrentUser delegate) {
        CurrentUserHelp.delegate = delegate;
    }
}
