package stepDefinitions;


import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import utils.ContextManager;
import java.io.IOException;


public class SearchGridPageStepDefinition {

    private Logger LOGGER = LogManager.getLogger(this.getClass());
    ContextManager contextManager;

    public SearchGridPageStepDefinition(ContextManager contextManager){
        this.contextManager = contextManager;
    }

    @Then("Click on product {string} and navigate to Product detail page")
    public void click_on_product_and_navigate_to_product_detail_page(String product) throws IOException {
        if(contextManager.pageObjectManager.getSearchGridPage().isItemPresent()){
            contextManager.pageObjectManager.getSearchGridPage().selectProduct(product);
        }else{
            Assert.fail("No item present on grid");
        }
    }
}
