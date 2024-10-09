package org.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/org/tests"},
        glue = {"org/tests"},
        plugin = {"pretty","html:Report/cucumber-reports/report.html"},
        monochrome = true)

public class NomoTestRunner extends AbstractTestNGCucumberTests {
}
