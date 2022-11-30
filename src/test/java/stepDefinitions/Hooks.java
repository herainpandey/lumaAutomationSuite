package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ContextManager;

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
}
