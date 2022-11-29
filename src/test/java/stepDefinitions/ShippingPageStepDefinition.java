package stepDefinitions;


import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ContextManager;

import java.util.Map;

public class ShippingPageStepDefinition {


    private Logger LOGGER = LogManager.getLogger(this.getClass());
    ContextManager contextManager;

    public ShippingPageStepDefinition(ContextManager contextManager){
        this.contextManager = contextManager;
    }
    @Then("Provide Shipping details and mode {string} then proceed to Review and Payment")
    public void provide_shipping_details_and_mode_then_proceed_to_review_and_payment(String shippingMode) {
        contextManager.pageObjectManager.getShippingPage().enterShippingDetails(contextManager.genericUtils.userGenerator(),shippingMode).clickNextBtn();

    }

}
