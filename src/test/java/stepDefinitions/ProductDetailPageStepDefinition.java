package stepDefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pojo.LumaShopping.ProductDetailPage;
import utils.ContextManager;

public class ProductDetailPageStepDefinition {

    ContextManager contextManager;
    ProductDetailPage productDetailPage;

    public ProductDetailPageStepDefinition(ContextManager contextManager){
        this.contextManager = contextManager;
        productDetailPage = contextManager.pageObjectManager.getProductDetailPage();
    }

    @When("Select Size {string} and Color {string} and go to cart page")
    public void select_size_and_color_and_go_to_cart_page(String size, String color) {
        productDetailPage.selectSizeAndColor(size,color).addToCartBtn();
    }

    @Then("Verify item {string} is added to the Cart and proceed to checkout")
    public void verify_item_is_added_to_the_cart_and_proceed_to_checkout(String product) throws InterruptedException {
        productDetailPage.goToCart(product);
    }

}
