package com.act.test.seleniumtest;

import com.act.test.pages.HomePage;
import com.act.test.pages.LoginPage;
import com.act.test.steps.TestInitializer;
import org.junit.Test;

public class LoginTest extends TestInitializer {

    @Test
    public void login() throws InterruptedException {

       CurrentPage = getInstance(HomePage.class);
       CurrentPage = CurrentPage.as(HomePage.class).clickLogin();

       Thread.sleep(2000);

       CurrentPage.as(LoginPage.class).enterUsernamePassword("admin", "password");
    }
}
