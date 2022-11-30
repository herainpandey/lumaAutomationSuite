package pojo.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;


public abstract class AbstractComponents {

    protected final Logger log = LogManager.getLogger(this.getClass());

    protected  static WebDriver driver;

    public AbstractComponents(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void scrollToElementJS(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void elementToClickJS(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",element);
    }

    public  boolean existsElement(WebElement element) {
        try {
            element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

}
