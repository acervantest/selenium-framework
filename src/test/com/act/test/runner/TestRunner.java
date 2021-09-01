package com.act.test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/com/act/test/features/"}, glue = {"com/act/test/steps"})
public class TestRunner { }
