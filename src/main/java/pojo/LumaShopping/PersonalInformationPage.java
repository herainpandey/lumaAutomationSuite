package pojo.LumaShopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pojo.common.AbstractComponents;

import java.util.Map;

public class PersonalInformationPage extends AbstractComponents {

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastName;

    public PersonalInformationPage(WebDriver driver){
        super(driver);
    }

    public void enterRegistrationInfo(Map<String,String> map){
        log.info("User enters FirstName and LastName ");
        firstName.sendKeys(map.get("firstName"));
        lastName.sendKeys(map.get("lastName"));
    }
}
