package com.act.framework.base;

import org.openqa.selenium.WebDriver;

public class DriverContext {

    public static WebDriver driver;

    public static Browser browser;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}
