package stepDefinitions;


import io.cucumber.java.en.Then;
import pojo.LumaShopping.ReviewAndPaymentPage;
import utils.ContextManager;
import java.io.IOException;


public class ReviewAndPaymentPageStepDefinition {

    ContextManager contextManager;
    ReviewAndPaymentPage reviewAndPaymentPage;

    public ReviewAndPaymentPageStepDefinition(ContextManager contextManager){
        this.contextManager = contextManager;
        reviewAndPaymentPage = contextManager.pageObjectManager.getReviewAndPaymentPage();
    }

    @Then("Confirm order total and Place the Order")
    public void confirm_order_total_and_place_the_order() throws IOException {
        reviewAndPaymentPage.verifyOrderTotalAndPlaceOrder(contextManager.genericUtils.getProperties("orderTotal"));
    }

}
