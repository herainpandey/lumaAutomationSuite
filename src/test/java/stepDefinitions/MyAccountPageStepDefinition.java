package stepDefinitions;


import io.cucumber.java.en.Then;
import pojo.LumaShopping.MyAccountPage;
import utils.ContextManager;

public class MyAccountPageStepDefinition {

    MyAccountPage myAccountPage;
    ContextManager contextManager;

    public MyAccountPageStepDefinition(ContextManager contextManager){
        this.contextManager = contextManager;
        myAccountPage = contextManager.pageObjectManager.getMyAccountPage();
    }

    @Then("Search product {string} via Search bar")
    public void search_product_via_search_bar(String product) {
        myAccountPage.search(product);
    }

    }
