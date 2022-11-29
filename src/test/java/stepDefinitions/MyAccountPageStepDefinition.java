package stepDefinitions;


import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ContextManager;

public class MyAccountPageStepDefinition {


    private Logger LOGGER = LogManager.getLogger(this.getClass());
    ContextManager contextManager;

    public MyAccountPageStepDefinition(ContextManager contextManager){
        this.contextManager = contextManager;
    }

    @Then("Search product {string} via Search bar")
    public void search_product_via_search_bar(String product) {
        contextManager.pageObjectManager.getMyAccountPage().search(product);
    }

    }
