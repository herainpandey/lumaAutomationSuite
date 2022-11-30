package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ContextManager;

import java.io.File;
import java.io.IOException;

public class Hooks {

    ContextManager contextManager;

    public Hooks(ContextManager contextManager){
        this.contextManager = contextManager;
    }

   @Before
   public void launchBrowser(){
       contextManager.driver.get("https://magento.softwaretestingboard.com/");
   }

    @After
    public void closeBrowser(){
       contextManager.driver.quit();
    }

    @AfterStep
    public void takeScreenShot(Scenario sc) throws IOException {
        if(sc.isFailed()){
          File sourcePath =   ((TakesScreenshot)contextManager.driver).getScreenshotAs(OutputType.FILE);
          byte [] fileContent = FileUtils.readFileToByteArray(sourcePath);
          sc.attach(fileContent,"image/png",sc.getName()+"_"+Math.random());
        }

    }
}
