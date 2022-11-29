package utils;

import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pojo.UserGenerator.UserGenerator;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;


public class GenericUtils {

    public WebDriver driver;
    public Map<String, String> userMap = null;

    public GenericUtils(WebDriver driver){
        this.driver=driver;
    }

    public String generateRandomAccount(){
        Random rand = new Random();
        int num = rand.nextInt(90000) + 10000;
        return String.valueOf(num);
    }


    public String generateRandomTransactionAmount(){
        Random rand = new Random();
        int num = rand.nextInt(900) + 100;
        return String.valueOf(num);

    }

    public String generateRandomSSNNumber(){
        Random rand = new Random();
        int num = rand.nextInt(900000000) + 100000000;
        return String.valueOf(num);

    }


    public String getProperties(String data) throws IOException {
        String value ="";
         try{
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\testData.properties");
            Properties prop = new Properties();
            prop.load(fis);
            value =  prop.getProperty(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }

    public Map<String, String> userGenerator() {

        if(userMap==null) {
             userMap = new HashMap<>();
            try {
                System.out.println("Generating user data");
                UserGenerator user = RestAssured.given().when().get("https://randomuser.me/api").then().extract().response().getBody().as(UserGenerator.class);
                userMap.put("firstName", user.getResults().get(0).getName().getFirst());
                userMap.put("lastName", user.getResults().get(0).getName().getLast());
                userMap.put("address", user.getResults().get(0).getLocation().getStreet().getName());
                userMap.put("city", user.getResults().get(0).getLocation().getCity());
                userMap.put("state", "Florida");
                userMap.put("zipcode", user.getResults().get(0).getLocation().getPostcode());
                userMap.put("phoneNumber", user.getResults().get(0).getPhone());
                userMap.put("ssn", generateRandomSSNNumber());
                userMap.put("account", generateRandomAccount());
                userMap.put("username", user.getResults().get(0).getLogin().getUsername());
                userMap.put("password", user.getResults().get(0).getLogin().getPassword() + "Test@123");
                userMap.put("email", user.getResults().get(0).getEmail());
                userMap.put("country", "United States");
                userMap.put("company", user.getResults().get(0).getName().getFirst() + "infotech.pvt.ltd");
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail(e.getMessage());
            }
        }else{
            System.out.println("Using existing data");
        }
        return userMap;
    }


}
