package Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java",glue = {"stepDefinitions"},plugin = { "pretty", "html:target/cucumber-reports" },
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}
