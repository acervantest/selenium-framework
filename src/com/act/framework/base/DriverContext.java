package com.act.framework.base;

import com.act.framework.config.Settings;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverContext {

    public static WebDriver driver;

    public static Browser browser;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static void waitForPageToLoad(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until( new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver input) {
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                }
            });
        } catch (TimeoutException error) {
            Settings.logger.write("Timeout waiting for page load request to complete.");
        }
    }

    public static void waitForLoad(){
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver input) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    public static void waitForElementVisible(final WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitForTextElementVisible(final WebElement webElement, final String text){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    public static void waitUntilTextDisplayed(final By elementFindBy, final String text){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(isTextDisplayed(elementFindBy, text));
    }

    public static ExpectedCondition<Boolean> isTextDisplayed(final By elementFindBy, final String text){
       return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return webDriver.findElement(elementFindBy).getText().contains(text);
            }
        };
    }

    public static void waitElementEnabled(final By elementFindBy){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(isElementEnabled(elementFindBy));
    }

    public static ExpectedCondition<Boolean> isElementEnabled(final By elementFindBy){
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return webDriver.findElement(elementFindBy).isEnabled();
            }
        };
    }
}
