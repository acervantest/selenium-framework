package com.act.test.steps;

import com.act.framework.base.Base;
import com.act.test.pages.CreateEmployeePage;
import com.act.test.pages.EmployeeListPage;
import com.act.test.pages.HomePage;
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
        Thread.sleep(3000);
    }

    @And("click employee list link")
    public void clickEmployeeListLink() throws InterruptedException {
        CurrentPage = CurrentPage.as(HomePage.class).clickEmployeeList();
        Thread.sleep(3000);
    }

    @Then("click create new button")
    public void clickCreateNewButton() throws InterruptedException {
        CurrentPage = CurrentPage.as(EmployeeListPage.class).clickCreateNewButton();
        Thread.sleep(3000);
    }

    @And("enter details")
    public void enterDetails(DataTable data) throws InterruptedException {
        List<List<String>> tableData = data.asLists();
        CurrentPage.as(CreateEmployeePage.class).enterEmployeeDetails(
                tableData.get(1).get(0).toString(), tableData.get(1).get(1).toString(),
                tableData.get(1).get(2).toString(), tableData.get(1).get(3).toString(),
                tableData.get(1).get(4).toString()
                );
        Thread.sleep(3000);
    }

    @And("click create button")
    public void clickCreateButton() throws InterruptedException {
        CurrentPage.as(CreateEmployeePage.class).clickCreateEmployeeButton();
        Thread.sleep(3000);
    }
}
