package pojo.LumaShopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pojo.common.AbstractComponents;

public class CreateAccountPage {
    private WebDriver driver;
   private SignInInformationPage signInInformationPage;
   private PersonalInformationPage personalInformationPage;


    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
        /*PageFactory.initElements(this.driver,SignInInformationPage.class);
        PageFactory.initElements(this.driver,PersonalInformationPage.class);*/
    }

    public SignInInformationPage getSignInInformationPage(){
        return new SignInInformationPage(driver);
    }

    public PersonalInformationPage getPersonalInformationPage(){
        return new PersonalInformationPage(driver);
    }


}
