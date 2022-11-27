package pojo.common;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractComponents {

    protected  static WebDriver driver;
    protected  static WebDriverWait wait;

    public AbstractComponents(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
