package Base;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pojo.UserGenerator.UserGenerator;

import utils.Helper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;


public class BaseTest{

    private static WebDriver driver;

    public static WebDriver initializeBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver =  new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public Map<String, String> userGenerator() {

        Map<String, String> userMap = new HashMap<String, String>();;
        try {
            // Generate Sender Data
            UserGenerator user = given().when().get("https://randomuser.me/api").then().extract().response().getBody().as(UserGenerator.class);
            userMap.put("firstName", user.getResults().get(0).getName().getFirst());
            userMap.put("lastName", user.getResults().get(0).getName().getLast());
            userMap.put("address", user.getResults().get(0).getLocation().getStreet().getName());
            userMap.put("city", user.getResults().get(0).getLocation().getCity());
            userMap.put("state", "Florida");
            userMap.put("zipcode", user.getResults().get(0).getLocation().getPostcode());
            userMap.put("phoneNumber", user.getResults().get(0).getPhone());
            userMap.put("ssn", Helper.generateRandomSSNNumber());
            userMap.put("account", Helper.generateRandomAccount());
            userMap.put("username", user.getResults().get(0).getLogin().getUsername());
            userMap.put("password", user.getResults().get(0).getLogin().getPassword()+"Test@123");
            userMap.put("email", user.getResults().get(0).getEmail());
            userMap.put("country", "United States");
            userMap.put("company", user.getResults().get(0).getName().getFirst()+"infotech.pvt.ltd");


        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
        return userMap;
    }

    @After
    public static  void closeBrowser(){
        driver.quit();
    }

}
