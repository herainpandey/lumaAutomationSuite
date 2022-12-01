package Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java",
        glue = {"stepDefinitions","Hooks"},
        plugin = { "pretty",
                "html:target/cucumber-reports.html" ,
                "rerun:target/failedrerun.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:FILE"},
        monochrome = true,
        tags="@Sanity")

public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
