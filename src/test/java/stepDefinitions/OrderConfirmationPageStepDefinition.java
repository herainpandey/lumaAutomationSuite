package stepDefinitions;


import io.cucumber.java.en.Then;
import pojo.LumaShopping.OrderConfirmationPage;
import utils.ContextManager;

public class OrderConfirmationPageStepDefinition {

    ContextManager contextManager;
    OrderConfirmationPage orderConfirmationPage;

    public OrderConfirmationPageStepDefinition(ContextManager contextManager){
        this.contextManager = contextManager;
        orderConfirmationPage= contextManager.pageObjectManager.getOrderConfirmationPage();

    }

    @Then("Verify purchase is successful")
    public void verify_purchase_is_successful(){
        orderConfirmationPage .verifyOrdersuccess();
    }

}
