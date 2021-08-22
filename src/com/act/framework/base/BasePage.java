package com.act.framework.base;

import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends Base{

    public BasePage(){
        PageFactory.initElements(DriverContext.driver, this);
    }

    public <T extends BasePage> T as(Class<T> page){
        try {
            return (T) this;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}
