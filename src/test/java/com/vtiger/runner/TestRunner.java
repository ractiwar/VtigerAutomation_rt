package com.vtiger.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features =  "src/test/resources/Features/",
        glue = "com.vtiger.stepdefinition",
        dryRun = false,
        //tags = "@running",
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-reports",
                "junit:target/cucumber.xml"
        }, monochrome = true
)
public class TestRunner {
}
