package com.act.test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/com/act/test/features/"}, glue = {"com/act/test/steps"})
public class TestRunner extends AbstractTestNGCucumberTests { }
