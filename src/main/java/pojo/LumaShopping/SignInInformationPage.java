package pojo.LumaShopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pojo.common.AbstractComponents;

import java.util.Map;

public class SignInInformationPage extends AbstractComponents {

    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='password-confirmation']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button[@type='submit']//span[contains(text(),'Account')]")
    private WebElement createAccountbtn;

    @FindBy(xpath = "//div[@class='message-error error message']")
    private WebElement errorMessage;

    public SignInInformationPage(WebDriver driver){
        super(driver);
    }

    public MyAccountPage enterUserPasswordAndRegister(Map<String,String> map) throws InterruptedException {
           log.info("User enters Email,Password, and retype Password to confirm ");
        do{
            email.sendKeys(map.get("email"));
            password.sendKeys(map.get("password"));
            confirmPassword.sendKeys(map.get("password"));
            createAccountbtn.click();
            Thread.sleep(2000);

            if(existsElement(errorMessage)){
                email.clear();
                String email = map.get("firstName")+Math.random()+"@gmail.com";
                map.put("email",email);
            }

        }while(existsElement(errorMessage));

        return new MyAccountPage(driver);
    }
}
