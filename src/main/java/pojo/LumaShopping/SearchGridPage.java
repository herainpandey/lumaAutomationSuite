package pojo.LumaShopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pojo.common.AbstractComponents;
import utils.Helper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SearchGridPage extends MyAccountPage {
    @FindBy(xpath = "//ol[@class='products list items product-items']/li")
    private List<WebElement> itemList;


    public SearchGridPage(WebDriver driver){
        super(driver);
    }

    public boolean isItemPresent(){
        if(itemList.size()==0){
            return false;
        }else{
            return true;
        }
    }

    public ProductDetailPage selectProduct(String productName) throws IOException {

        LOGGER.info("Selecting "+productName+" from product link ");

        itemList.stream().filter(element -> element.findElement(By.xpath("//ol[contains(@class,'product-items')]/li//strong/a"))
                    .getText().equalsIgnoreCase(productName)).findFirst().get().click();

        return PageFactory.initElements(driver,ProductDetailPage.class);
    }

}
