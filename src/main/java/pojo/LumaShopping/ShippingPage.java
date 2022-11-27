package pojo.LumaShopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pojo.common.AbstractComponents;
import utils.Helper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ShippingPage extends AbstractComponents {

    @FindBy(xpath = "(//input[@type='email'])[2]")
    private WebElement email;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name='company']")
    private WebElement company;

    @FindBy(xpath = "//input[@name='street[0]']")
    private WebElement street;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement city;

    @FindBy(xpath = "(//select[@class='select'])[1]")
    private WebElement state;

    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement postcode;

    @FindBy(xpath = "(//select[@class='select'])[2]")
    private WebElement country ;

    @FindBy(xpath = "//input[@name='telephone']")
    private WebElement telephone;

    @FindBy(xpath = "//tbody/tr/td")
    private List<WebElement> shippingMethod;

    @FindBy(xpath = "//button[@type='submit']//span[text()='Next']")
    private WebElement nextBtn;

    public ShippingPage(WebDriver driver){
        super(driver);
    }

    public ShippingPage enterShippingDetails(Map<String, String> mshipdetail,String shippingMode){
        company.sendKeys(mshipdetail.get("company"));
        street.sendKeys(mshipdetail.get("address"));
        city.sendKeys(mshipdetail.get("city"));
        Select sel = new Select(state);
        sel.selectByVisibleText(mshipdetail.get("state"));
        postcode.sendKeys(mshipdetail.get("zipcode"));
        sel = new Select(country);
        sel.selectByVisibleText(mshipdetail.get("country"));
        telephone.sendKeys(mshipdetail.get("phoneNumber"));
        shippingMethod.stream().filter(element -> element.getText().equalsIgnoreCase(shippingMode)).findFirst().get().click();
        return this;
    }

    public ReviewAndPaymentPage clickNextBtn(){
        nextBtn.click();
        return new ReviewAndPaymentPage(driver);
    }

}
