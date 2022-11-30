package stepDefinitions;


import io.cucumber.java.en.Given;
import pojo.LumaShopping.LumaHomePage;
import utils.ContextManager;

public class LumaHomePageStepDefinition {

    LumaHomePage lumaHomePage;
    ContextManager contextManager;

   public LumaHomePageStepDefinition(ContextManager contextManager){
     this.contextManager = contextManager;
     lumaHomePage = contextManager.pageObjectManager.getLumaHomePage();
   }

    @Given("User is on Luma Home Page and Navigates to Create Account Page")
    public void User_is_on_Luma_Home_Page_and_Navigates_to_Create_Account_Page() {
        lumaHomePage.createUserAccount();
    }
}
