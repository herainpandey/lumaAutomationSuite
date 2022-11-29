package stepDefinitions;

import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ContextManager;

import java.util.Map;

public class CreateAccountPageStepDefinition {

    private Logger LOGGER = LogManager.getLogger(this.getClass());
    private Map<String,String> userInfo =null;
    ContextManager contextManager;

    public CreateAccountPageStepDefinition(ContextManager contextManager){
        this.contextManager = contextManager;
    }

    @Then("Create User Account")
    public void create_user_account() throws InterruptedException {
        userInfo = contextManager.genericUtils.userGenerator();
        contextManager.pageObjectManager.getLumaHomePage().createUserAccount();
        contextManager.pageObjectManager.getCreateAccountPage().getPersonalInformationPage().enterRegistrationInfo(userInfo);
        contextManager.pageObjectManager.getCreateAccountPage().getSignInInformationPage().enterUserPasswordAndRegister(userInfo);
    }

}
