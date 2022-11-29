package utils;

import org.openqa.selenium.WebDriver;
import pojo.LumaShopping.*;

public class PageObjectManager {
    //Factory Design Pattern : creating objects for all page object files

    public WebDriver driver;
    public LumaHomePage lumaHomePage;
    public CreateAccountPage createAccountPage;
    public MyAccountPage myAccountPage;
    public OrderConfirmationPage orderConfirmationPage;
    public PersonalInformationPage personalInformationPage;
    public ProductDetailPage productDetailPage;
    public ReviewAndPaymentPage reviewAndPaymentPage;
    public SearchGridPage searchGridPage;
    public ShippingPage shippingPage;
    public SignInInformationPage signInInformationPage;


    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public LumaHomePage getLumaHomePage()
    {
        lumaHomePage = new LumaHomePage(driver);
        return lumaHomePage;
    }
    public CreateAccountPage getCreateAccountPage()
    {
        createAccountPage = new CreateAccountPage(driver);
        return createAccountPage;
    }
    public MyAccountPage getMyAccountPage()
    {
        myAccountPage = new MyAccountPage(driver);
        return myAccountPage;
    }
    public OrderConfirmationPage getOrderConfirmationPage()
    {
        orderConfirmationPage = new OrderConfirmationPage(driver);
        return orderConfirmationPage;
    }
    public PersonalInformationPage getPersonalInformationPage()
    {
        personalInformationPage = new PersonalInformationPage(driver);
        return personalInformationPage;
    }
    public ProductDetailPage getProductDetailPage()
    {
        productDetailPage = new ProductDetailPage(driver);
        return productDetailPage;
    }
    public ReviewAndPaymentPage getReviewAndPaymentPage()
    {
        reviewAndPaymentPage = new ReviewAndPaymentPage(driver);
        return reviewAndPaymentPage;
    }
    public SearchGridPage getSearchGridPage()
    {
        searchGridPage = new SearchGridPage(driver);
        return searchGridPage;
    }
    public ShippingPage getShippingPage()
    {
        shippingPage = new ShippingPage(driver);
        return shippingPage;
    }
    public SignInInformationPage getSignInInformationPage()
    {
        signInInformationPage = new SignInInformationPage(driver);
        return signInInformationPage;
    }

}
