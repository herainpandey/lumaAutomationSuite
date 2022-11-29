package stepDefinitions;


import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pojo.LumaShopping.OrderConfirmationPage;
import pojo.LumaShopping.ReviewAndPaymentPage;
import utils.ContextManager;

import java.util.Map;

public class OrderConfirmationPageStepDefinition {


    private Logger LOGGER = LogManager.getLogger(this.getClass());
    ContextManager contextManager;

    public OrderConfirmationPageStepDefinition(ContextManager contextManager){
        this.contextManager = contextManager;
    }

    @Then("Verify purchase is successful")
    public void verify_purchase_is_successful(){
        contextManager.pageObjectManager.getOrderConfirmationPage().verifyOrdersuccess();
    }

}
