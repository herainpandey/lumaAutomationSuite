package Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"@target/failedrerun.txt"},
        glue = {"stepDefinitions","Hooks"},
        plugin = { "pretty",
                "html:target/cucumber-reports.html" ,
                "json:target/cucumber-reports.json" },
        monochrome = true)
public class FailedRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }


}
