package stepDefinitions;


import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ContextManager;

import java.util.Map;

public class LumaHomePageStepDefinition {

    private Logger LOGGER = LogManager.getLogger(this.getClass());
    ContextManager contextManager;

   public LumaHomePageStepDefinition(ContextManager contextManager){
    this.contextManager = contextManager;
   }

    @Given("Launch Luma Site")
    public void launch_luma_site() {
        contextManager.testBase.webDriverManager().get("https://magento.softwaretestingboard.com/");
    }
}
