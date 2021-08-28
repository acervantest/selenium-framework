package com.act.framework.base;

public abstract class BasePage extends Base {

    public <T extends BasePage> T as(Class<T> page){
        try {
            return (T) this;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}
