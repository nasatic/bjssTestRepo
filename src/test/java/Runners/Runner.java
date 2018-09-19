package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/FeatureFiles/",
        glue = "StepDef",
        format = {"pretty", "html:target/cucumber-html-reports",
                "json:target/cucumber.json"},
        tags = {"@Ibe"})

public class Runner extends AbstractTestNGCucumberTests {
}
