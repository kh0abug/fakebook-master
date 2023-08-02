package com.khoabug.coffeshop.common.utils;

public class SessionUtil {

    private SessionUtil instance = null;

    public SessionUtil getInstance(){
        if (instance == null){
            return new SessionUtil();
        }
        return instance;
    }
}
