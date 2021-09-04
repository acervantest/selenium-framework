package com.act.test.pages;

import com.act.framework.base.BasePage;
import com.act.framework.base.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateEmployeePage extends BasePage {

    @FindBy(how = How.ID, using = "Name")
    private WebElement txtName;

    @FindBy(how = How.ID, using = "Salary")
    private WebElement txtSalary;

    @FindBy(how = How.ID, using = "DurationWorked")
    private WebElement txtDurationWorked;

    @FindBy(how = How.ID, using = "Grade")
    private WebElement txtGrade;

    @FindBy(how = How.ID, using = "Email")
    private WebElement txtEmail;

    @FindBy(how = How.XPATH, using = "//input[@value='Create']")
    private WebElement btnCreateEmployee;

    public void clickCreateEmployeeButton(){
        btnCreateEmployee.submit();
    }

    public void enterEmployeeDetails(String name, String salary, String durationWorked, String grade, String email){
        DriverContext.waitForElementVisible(txtName);
        txtName.sendKeys(name);
        txtSalary.sendKeys(salary);
        txtDurationWorked.sendKeys(durationWorked);
        txtGrade.sendKeys(grade);
        txtEmail.sendKeys(email);
    }
}
