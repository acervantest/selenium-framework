package com.act.test.runner;

import io.cucumber.testng.*;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(features = {"src/com/act/test/features/"}, glue = {"com/act/test/steps"})
public class TestRunner {// extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "features")
    public void feature(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] features(ITestContext context){
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        testNGCucumberRunner.finish();
    }

}
