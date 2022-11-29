package stepDefinitions;


import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ContextManager;
import java.io.IOException;


public class ReviewAndPaymentPageStepDefinition {


    private Logger LOGGER = LogManager.getLogger(this.getClass());
    ContextManager contextManager;

    public ReviewAndPaymentPageStepDefinition(ContextManager contextManager){
        this.contextManager = contextManager;
    }

    @Then("Confirm order total and Place the Order")
    public void confirm_order_total_and_place_the_order() throws IOException {
         contextManager.pageObjectManager.getReviewAndPaymentPage().verifyOrderTotalAndPlaceOrder(contextManager.genericUtils.getProperties("orderTotal"));
    }

}
