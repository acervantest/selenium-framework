package steps;

import com.act.framework.base.Base;
import com.act.framework.base.DriverContext;
import com.act.framework.utilities.CucumberUtil;
import pages.CreateEmployeePage;
import pages.EmployeeListPage;
import pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class EmployeeStepDefs extends Base {

    @Given("the application is open")
    public void theApplicationIsOpen() throws InterruptedException {
        CurrentPage = getInstance(HomePage.class);
        Assert.assertTrue("Home page is not displayed", CurrentPage.as(HomePage.class).isDisplayed());
        DriverContext.waitForPageToLoad();
    }

    @And("click employee list link")
    public void clickEmployeeListLink() throws InterruptedException {
        CurrentPage = CurrentPage.as(HomePage.class).clickEmployeeList();
        DriverContext.waitForPageToLoad();
    }

    @Then("click create new button")
    public void clickCreateNewButton() throws InterruptedException {
        CurrentPage = CurrentPage.as(EmployeeListPage.class).clickCreateNewButton();
        DriverContext.waitForPageToLoad();
    }

    @And("enter details")
    public void enterDetails(DataTable data) throws InterruptedException {
        List<List<String>> tableData = data.asLists();

        CucumberUtil.convertDataTableToDictionary(data);

        CurrentPage.as(CreateEmployeePage.class).enterEmployeeDetails(
                CucumberUtil.getCellValueWithRowIndex("name",2),
                CucumberUtil.getCellValueWithRowIndex("salary",2),
                CucumberUtil.getCellValueWithRowIndex("durationworked",2),
                CucumberUtil.getCellValueWithRowIndex("grade",2),
                CucumberUtil.getCellValueWithRowIndex("email",2)
        );
    }

    @And("click create button")
    public void clickCreateButton() throws InterruptedException {
        CurrentPage.as(CreateEmployeePage.class).clickCreateEmployeeButton();
    }
}
