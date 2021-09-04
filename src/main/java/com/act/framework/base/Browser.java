package com.act.framework.base;

import org.openqa.selenium.WebDriver;

public class Browser {

    private WebDriver _driver;

    public Browser(WebDriver driver){
        _driver = driver;
    }

    public BrowserType type;

    public void goToUrl(String url){
        _driver.get(url);
    }

    public void maximize(){
        _driver.manage().window().maximize();
    }

}