package com.act.test.features.seleniumtest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class LoginTest {

    private WebDriver _driver = null;

    @Before
    public void initialize(){
        //open the browser
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
        _driver = new ChromeDriver();
        _driver.navigate().to("https://demosite.executeautomation.com/Login.html");
    }

    @Test
    public void login(){
        _driver.findElement(By.name("UserName")).sendKeys("admin");
        _driver.findElement(By.name("Password")).sendKeys("admin");
        _driver.findElement(By.name("Login")).submit();
    }
}
