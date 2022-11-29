package pojo.LumaShopping;

import com.google.common.util.concurrent.Uninterruptibles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pojo.common.AbstractComponents;
import java.time.Duration;

public class OrderConfirmationPage extends AbstractComponents {

    @FindBy(xpath = "//h1[@class='page-title']")
    private WebElement message;

    @FindBy(xpath = "//div[@class='checkout-success']/p[1]")
    private WebElement orderConfirmaion;

    public OrderConfirmationPage(WebDriver driver){
        super(driver);
    }

    public void verifyOrdersuccess()  {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        if(message.getText().equalsIgnoreCase("Thank you for your purchase!")){
            log.info("=====================");
            log.info(message.getText());
            log.info(orderConfirmaion.getText());
            log.info("=====================");

        }else{
            Assert.fail("Order is not successful");
        }
    }

}
