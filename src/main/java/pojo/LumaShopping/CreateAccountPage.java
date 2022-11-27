package pojo.LumaShopping;

import org.openqa.selenium.WebDriver;

public class CreateAccountPage {
   private WebDriver driver;
   private SignInInformationPage signInInformationPage;
   private PersonalInformationPage personalInformationPage;


    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public SignInInformationPage getSignInInformationPage(){
        return new SignInInformationPage(driver);
    }

    public PersonalInformationPage getPersonalInformationPage(){
        return new PersonalInformationPage(driver);
    }


}
