package stepDefinitions;

import Base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pojo.LumaShopping.*;
import utils.Helper;


import java.io.IOException;
import java.util.Map;

public class StepDefinition {

    private Map<String,String> userInfo =null;
    private BaseTest baseTest;
    private WebDriver driver;
    private LumaHomePage lumaHomePage;
    private CreateAccountPage createAccountPage;
    private MyAccountPage myAccountPage;
    private SearchGridPage searchGridPage;
    private OrderConfirmationPage orderConfirmationPage;

    private ProductDetailPage productDetailPage;
    private ReviewAndPaymentPage reviewAndPaymentPage;
    private ShippingPage shippingPage;

    @Given("Launch Luma Site and go to Create an Account page")
    public void launch_luma_site_and_go_to_create_an_account_page() {
        baseTest = new BaseTest();
        driver = baseTest.initializeBrowser();
        driver.get("https://magento.softwaretestingboard.com/");
        lumaHomePage = new LumaHomePage(driver);
        createAccountPage = lumaHomePage.createUserAccount();
    }
    @Given("Provide User information and create Account")
    public void provide_user_information_and_create_account()  throws InterruptedException {
        userInfo = baseTest.userGenerator();
        createAccountPage.getPersonalInformationPage().enterRegistrationInfo(userInfo);
        myAccountPage = createAccountPage.getSignInInformationPage().enterUserPasswordAndRegister(userInfo);
    }
    @Then("Search product {string} via Search bar and navigate to Product grid")
    public void search_product_via_search_bar_and_navigate_to_product_grid(String product) {
        searchGridPage = myAccountPage.search(product);

    }
    @Then("Click on product {string} and navigate to Product detail page")
    public void click_on_product_and_navigate_to_product_detail_page(String product) throws IOException {
        if(searchGridPage.isItemPresent()){
            productDetailPage = searchGridPage.selectProduct(product);
        }
    }
    @Then("Select Size {string} and Color {string} and click on Add to Cart button")
    public void select_size_and_color_and_click_on_add_to_cart_button(String size, String color) {
        productDetailPage.selectSizeAndColor(size,color).addToCartBtn();
    }
    @Then("Verify item {string} is added to the Cart and proceed to checkout")
    public void verify_item_is_added_to_the_cart_and_proceed_to_checkout(String product) throws IOException, InterruptedException {
        shippingPage = productDetailPage.goToCart(product);

    }
    @Then("Provide Shipping details and mode {string} then proceed to Review and Payment")
    public void provide_shipping_details_and_mode_then_proceed_to_review_and_payment(String shippingMode) {
        reviewAndPaymentPage = shippingPage.enterShippingDetails(userInfo,shippingMode).clickNextBtn();
    }
    @Then("Confirm order total and Place the Order")
    public void confirm_order_total_and_place_the_order() throws IOException {
        orderConfirmationPage = reviewAndPaymentPage.verifyOrderTotalAndPlaceOrder();
    }
    @Then("Verify purchase is successful")
    public void verify_purchase_is_successful(){
        orderConfirmationPage.verifyOrdersuccess();
    }

}
