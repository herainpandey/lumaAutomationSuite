package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import java.time.Duration;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver()  {

        String browserProp = "firefox";
        String browserMvn=System.getProperty("browser");
        String browser = browserMvn!=null ? browserMvn : browserProp;

        WebDriver driverlocal = null;
            if(driverlocal==null) {
                switch (browser){
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--disable-notifications");
                        driverlocal = new ChromeDriver(options);
                        driverlocal.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        driverlocal.manage().window().maximize();
                        DriverFactory.driver.set(driverlocal);
                    break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        FirefoxOptions foption = new FirefoxOptions();
                        foption.addArguments("--disable-notifications");
                        driverlocal = new FirefoxDriver(foption);
                        driverlocal.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        driverlocal.manage().window().maximize();
                        DriverFactory.driver.set(driverlocal);
                    break;
                    default:
                        Assert.fail("Invalid browser");
                        break;
                }
            }
            return DriverFactory.driver.get();
}
}
