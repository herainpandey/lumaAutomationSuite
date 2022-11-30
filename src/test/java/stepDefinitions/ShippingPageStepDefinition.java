package stepDefinitions;


import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pojo.LumaShopping.ShippingPage;
import utils.ContextManager;

public class ShippingPageStepDefinition {

    ContextManager contextManager;
    ShippingPage shippingPage;

    public ShippingPageStepDefinition(ContextManager contextManager){
        this.contextManager = contextManager;;
        shippingPage= contextManager.pageObjectManager.getShippingPage();
    }
    @Then("Provide Shipping details and mode {string} then proceed to Review and Payment")
    public void provide_shipping_details_and_mode_then_proceed_to_review_and_payment(String shippingMode) {
        shippingPage.enterShippingDetails(contextManager.genericUtils.userGenerator(),shippingMode).clickNextBtn();

    }

}
