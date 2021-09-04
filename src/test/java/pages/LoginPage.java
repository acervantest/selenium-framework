package pages;

import com.act.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    public LoginPage() {}

    @FindBy(how = How.NAME, using = "UserName")
    private WebElement txtUserName;

    @FindBy(how = How.NAME, using = "Password")
    private WebElement txtPassword;

    @FindBy(how = How.CSS, using = "[class*='btn-default']")
    private WebElement btnLogin;

    public void enterUsernamePassword(String userName, String password){
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
    }

    public HomePage clickLogin(){
        btnLogin.submit();
        return getInstance(HomePage.class);
    }
}
