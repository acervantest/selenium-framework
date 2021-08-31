package com.act.test.features.seleniumtest;

import com.act.test.features.pages.HomePage;
import com.act.test.features.pages.LoginPage;
import org.junit.Test;

public class LoginTest extends TestInitializer {

    @Test
    public void login() throws InterruptedException {

       CurrentPage = getInstance(HomePage.class);
       CurrentPage = CurrentPage.as(HomePage.class).clickLogin();

       Thread.sleep(2000);

       CurrentPage.as(LoginPage.class).login("admin", "password");
    }
}
