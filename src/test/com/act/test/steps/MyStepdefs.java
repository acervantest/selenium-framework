package com.act.test.steps;

import com.act.framework.base.Base;
import com.act.test.pages.HomePage;
import com.act.test.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class MyStepdefs extends Base {

    @Given("the app is open")
    public void theAppIsOpen() throws InterruptedException {
        CurrentPage = getInstance(HomePage.class);
        Assert.assertTrue("Home page is not displayed", CurrentPage.as(HomePage.class).isDisplayed());
        Thread.sleep(3000);
    }

    @Then("click login link")
    public void clickLoginLink() throws InterruptedException {
        CurrentPage = CurrentPage.as(HomePage.class).clickLogin(); // NAVIGATING TO LOGIN PAGE
        Thread.sleep(3000);
    }

    @When("enter username and password")
    public void enterUsernameAndPassword(DataTable data) {
        List<List<String>> tableData = data.asLists();
        CurrentPage.as(LoginPage.class).enterUsernamePassword(tableData.get(1).get(0).toString(), tableData.get(1).get(1).toString());
    }

    @Then("click login button")
    public void clickLoginButton() throws InterruptedException {
        CurrentPage = CurrentPage.as(LoginPage.class).clickLogin(); // NAVIGATING TO HOME PAGE
        Thread.sleep(3000);
    }

    @Then("username and hello should be displayed")
    public void usernameAndHelloShouldBeDisplayed() {
        Assert.assertEquals("The user is not admin", CurrentPage.as(HomePage.class).getLoggedInUser(), "Hello admin!");
    }
}
