package pojo.LumaShopping;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import pojo.common.AbstractComponents;
import utils.Helper;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.sql.SQLOutput;
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
            System.out.println("=====================");
            System.out.println(message.getText());
            System.out.println(orderConfirmaion.getText());
            System.out.println("=====================");
        }else{
            System.out.println("Order is not successful");
        }
    }

}
