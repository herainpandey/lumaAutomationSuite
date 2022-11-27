package pojo.LumaShopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pojo.common.AbstractComponents;

public class LumaHomePage extends AbstractComponents {


    @FindBy(xpath ="(//a[text()='Create an Account'])[1]")
    private WebElement createAccount;

    public LumaHomePage(WebDriver driver){
     super(driver);
    }

    public CreateAccountPage createUserAccount(){
         LOGGER.info("User clicks on create account link");
         createAccount.click();
         return new CreateAccountPage(driver);
    }

}
