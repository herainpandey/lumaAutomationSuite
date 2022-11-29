package pojo.LumaShopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pojo.common.AbstractComponents;
import java.io.IOException;


public class ReviewAndPaymentPage extends AbstractComponents {

    @FindBy(xpath = "//tr[@class='grand totals']//span")
    private WebElement orderTotal;

    @FindBy(xpath = "//span[normalize-space()='Place Order']")
    private WebElement placeOrderBtn;

    public ReviewAndPaymentPage(WebDriver driver){
        super(driver);
    }

    public OrderConfirmationPage verifyOrderTotalAndPlaceOrder(String expectedTotal) throws IOException {
        if(orderTotal.getText().equalsIgnoreCase(expectedTotal)){
            log.info("Order Total is matched , Not click on Place Order Button");

            elementToClickJS(placeOrderBtn);
            return PageFactory.initElements(driver,OrderConfirmationPage.class);
        }
        log.info("Order Total not expected");
        return null;
    }

}
