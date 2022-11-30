package stepDefinitions;

import io.cucumber.java.en.Then;
import pojo.LumaShopping.CreateAccountPage;
import utils.ContextManager;

import java.util.Map;

public class CreateAccountPageStepDefinition {

    private Map<String,String> userInfo =null;
    ContextManager contextManager;
    CreateAccountPage createAccountPage;

    public CreateAccountPageStepDefinition(ContextManager contextManager){
        this.contextManager = contextManager;
        createAccountPage = contextManager.pageObjectManager.getCreateAccountPage();

    }

    @Then("Create User Account")
    public void create_user_account() throws InterruptedException {
        userInfo = contextManager.genericUtils.userGenerator();
        createAccountPage.getPersonalInformationPage().enterRegistrationInfo(userInfo);
        createAccountPage.getSignInInformationPage().enterUserPasswordAndRegister(userInfo);
    }

}
