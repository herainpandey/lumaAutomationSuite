package utils;

import org.openqa.selenium.WebDriver;

public class ContextManager {

    public PageObjectManager pageObjectManager;
    public GenericUtils genericUtils;
    public WebDriver driver;

    public ContextManager(){
        driver= DriverFactory.getDriver();
        pageObjectManager = new PageObjectManager(driver);
        genericUtils = new GenericUtils(driver);

    }
}
