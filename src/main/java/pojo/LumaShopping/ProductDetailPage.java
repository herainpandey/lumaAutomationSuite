package pojo.LumaShopping;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pojo.common.AbstractComponents;
import utils.Helper;

import java.io.IOException;
import java.util.List;

public class ProductDetailPage extends AbstractComponents {

    @FindBy(xpath = "(//div[@role='listbox'])[1]/div")
    private List<WebElement> itemSizeList;

    @FindBy(xpath = "(//div[@role='listbox'])[2]/div")
    private List<WebElement> itemColorList;

    @FindBy(xpath = "//span[normalize-space()='Add to Cart']")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//div[@role='alert']/div/div")
    private WebElement successToast;

    @FindBy(xpath = "//a[@class='action showcart']")
    private WebElement cartBtn;

    @FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
    private WebElement checkoutBtn;

    public ProductDetailPage(WebDriver driver){
        super(driver);
    }

    public ProductDetailPage selectSizeAndColor(String size, String color){
        itemSizeList.stream().filter(element -> element.getText().equalsIgnoreCase(size)).forEach(element -> element.click());

        itemColorList.stream().filter(element ->element.getAttribute("option-label").equalsIgnoreCase(color))
                .forEach(element -> element.click());
        return this;
    }

    public ProductDetailPage addToCartBtn(){
        addToCartBtn.click();
        return this;
    }


    public boolean isProductAdded(String product) throws IOException {
        boolean flag= false;
        if(existsElement(successToast)){
            flag = successToast.getText().equalsIgnoreCase("You added "+product+" to your shopping cart.");
        }
        return flag;
    }

    public ShippingPage goToCart(String product) throws IOException, InterruptedException {
        boolean flag = isProductAdded(product);
        if(flag){
            cartBtn.click();
            Thread.sleep(5000);
            checkoutBtn.click();
            return PageFactory.initElements(driver,ShippingPage.class);
        }

        return null;
    }

}
