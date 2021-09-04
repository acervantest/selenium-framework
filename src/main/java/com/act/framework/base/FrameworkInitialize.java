package com.act.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class FrameworkInitialize extends Base {

    public void initializeBrowser(BrowserType browserType){

        WebDriver webDriver = null;

        switch (browserType){
            case Chrome:
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
                webDriver = new ChromeDriver();
                break;
            case Firefox:
                webDriver = new FirefoxDriver();
                break;
        }

        DriverContext.setDriver(webDriver);

        DriverContext.browser = new Browser(webDriver);
    }

}
