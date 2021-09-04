package seleniumtest;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import steps.TestInitializer;

public class LoginTest extends TestInitializer {

    @Test
    public void login() throws InterruptedException {

       CurrentPage = getInstance(HomePage.class);
       CurrentPage = CurrentPage.as(HomePage.class).clickLogin();

       Thread.sleep(2000);

       CurrentPage.as(LoginPage.class).enterUsernamePassword("admin", "password");
    }
}
