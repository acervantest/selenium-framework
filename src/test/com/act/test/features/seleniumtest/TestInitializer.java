package com.act.test.features.seleniumtest;

import com.act.framework.base.BrowserType;
import com.act.framework.base.DriverContext;
import com.act.framework.base.FrameworkInitialize;
import com.act.framework.config.ConfigReader;
import com.act.framework.config.Settings;
import com.act.framework.utilities.LogUtil;
import org.junit.Before;
import java.io.IOException;

public class TestInitializer extends FrameworkInitialize {

    @Before
    public void initialize() throws IOException {
        //initialize config
        ConfigReader.populateSettings();

        Settings.logger = new LogUtil();
        Settings.logger.createLogFile();
        Settings.logger.write("Framework initializing... ");

        initializeBrowser(BrowserType.Chrome);
        Settings.logger.write("Browser initialized... ");

        DriverContext.browser.goToUrl(Settings.mainUrl);
        Settings.logger.write("Navigated to url: "+ Settings.mainUrl);
    }
}
