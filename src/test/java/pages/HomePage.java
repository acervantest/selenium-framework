package pages;

import com.act.framework.base.BasePage;
import com.act.framework.base.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    public HomePage() {}

    @FindBy( how = How.LINK_TEXT, using = "Login")
    private WebElement lnkLogin;

    @FindBy( how = How.LINK_TEXT, using = "Employee List")
    private WebElement lnkEmployeeList;

    @FindBy( how = How.XPATH, using = "//a[@title='Manage']")
    private WebElement lnkUsername;

    public LoginPage clickLogin(){
        lnkLogin.click();
        return getInstance(LoginPage.class);
    }

    public boolean isDisplayed(){
        return lnkLogin.isDisplayed();
    }

    public String getLoggedInUser(){
        return lnkUsername.getText();
    }

    public EmployeeListPage clickEmployeeList(){
        DriverContext.waitForElementVisible(lnkEmployeeList);
        lnkEmployeeList.click();
        return getInstance(EmployeeListPage.class);
    }
}
