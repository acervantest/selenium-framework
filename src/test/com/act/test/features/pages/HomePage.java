package com.act.test.features.pages;

import com.act.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    public HomePage() {

    }

    @FindBy( how = How.LINK_TEXT, using = "Login")
    public WebElement lnkLogin;

    @FindBy( how = How.LINK_TEXT, using = "Employee List")
    public WebElement lnkEmployeeList;

    public LoginPage clickLogin(){
        lnkLogin.click();
        return getInstance(LoginPage.class);
    }
}
