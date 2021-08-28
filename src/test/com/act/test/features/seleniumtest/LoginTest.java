package com.act.test.features.seleniumtest;

import com.act.framework.base.BrowserType;
import com.act.framework.base.DriverContext;
import com.act.framework.base.FrameworkInitialize;
import com.act.framework.config.ConfigReader;
import com.act.framework.utilities.LogUtil;
import com.act.test.features.pages.HomePage;
import com.act.test.features.pages.LoginPage;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoginTest extends FrameworkInitialize {

    @Before
    public void initialize() throws IOException {

        ConfigReader.populateSettings();

        LogUtil logUtil = new LogUtil();
        logUtil.createLogFile();
        logUtil.write("Framework initializing... ");

        initializeBrowser(BrowserType.Chrome);
        DriverContext.browser.goToUrl("http://eaapp.somee.com/");
    }

    @Test
    public void login() throws InterruptedException {

       CurrentPage = getInstance(HomePage.class);
       CurrentPage = CurrentPage.as(HomePage.class).clickLogin();

       Thread.sleep(2000);

       CurrentPage.as(LoginPage.class).login("admin", "password");
    }
}
