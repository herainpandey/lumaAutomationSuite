package pojo.LumaShopping;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pojo.common.AbstractComponents;

import java.util.List;

public class MyAccountPage extends AbstractComponents {

    @FindBy(xpath = "//input[@id='search']")
    private WebElement searchbar;

    @FindBy(xpath = "//div[@id='search_autocomplete']//li/span")
    private List<WebElement> searchlist;

    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    public SearchGridPage search(String searchItem){
        LOGGER.info("User is going to enter Item in Search box and Hit Enter");
        searchbar.sendKeys(searchItem);
        searchbar.sendKeys(Keys.ENTER);
        return new SearchGridPage(driver);

    }
}
