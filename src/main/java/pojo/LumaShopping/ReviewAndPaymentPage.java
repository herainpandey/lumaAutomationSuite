package pojo.LumaShopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pojo.common.AbstractComponents;
import utils.Helper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReviewAndPaymentPage extends AbstractComponents {

    @FindBy(xpath = "//tr[@class='grand totals']//span")
    private WebElement orderTotal;

    @FindBy(xpath = "//span[normalize-space()='Place Order']")
    private WebElement placeOrderBtn;

    public ReviewAndPaymentPage(WebDriver driver){
        super(driver);
    }

    public OrderConfirmationPage verifyOrderTotalAndPlaceOrder() throws IOException {
        if(orderTotal.getText().equalsIgnoreCase(Helper.getProperties("orderTotal"))){
            LOGGER.info("Order Total is matched , Not click on Place Order Button");

            elementToClickJS(placeOrderBtn);
            return PageFactory.initElements(driver,OrderConfirmationPage.class);
        }
        LOGGER.info("Order Total not expected");
        return null;
    }

}
