package pages;

import com.act.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmployeeListPage extends BasePage {

    @FindBy(how = How.NAME, using = "searchTerm")
    private WebElement txtSearch;

    @FindBy(how = How.LINK_TEXT, using = "Create New")
    private WebElement lnkCreateNew;

    @FindBy(how = How.CLASS_NAME, using = "table")
    private WebElement tblEmployeeList;

    public CreateEmployeePage clickCreateNewButton(){
        lnkCreateNew.click();
        return getInstance(CreateEmployeePage.class);
    }

    public WebElement getEmployeeList(){
        return tblEmployeeList;
    }
}
