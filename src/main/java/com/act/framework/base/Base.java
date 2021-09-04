package com.act.framework.base;

import org.openqa.selenium.support.PageFactory;

public class Base {

    public static BasePage CurrentPage;

    public <T extends BasePage> T getInstance(Class<T> page){
        Object obj = PageFactory.initElements(DriverContext.driver, page);
        return page.cast(obj);
    }
}
