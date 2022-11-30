package stepDefinitions;


import io.cucumber.java.en.Then;
import org.testng.Assert;
import pojo.LumaShopping.SearchGridPage;
import utils.ContextManager;
import java.io.IOException;


public class SearchGridPageStepDefinition {

    ContextManager contextManager;
    SearchGridPage searchGridPage;

    public SearchGridPageStepDefinition(ContextManager contextManager){
        this.contextManager = contextManager;
        searchGridPage=contextManager.pageObjectManager.getSearchGridPage();
    }

    @Then("Click on product {string} and navigate to Product detail page")
    public void click_on_product_and_navigate_to_product_detail_page(String product) throws IOException {
        if(searchGridPage.isItemPresent()){
            searchGridPage.selectProduct(product);
        }else{
            Assert.fail("No item present on grid");
        }
    }
}
