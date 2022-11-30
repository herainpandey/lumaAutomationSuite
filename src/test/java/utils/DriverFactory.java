package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        WebDriver driverlocal = null;
            if(driverlocal==null) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                driverlocal = new ChromeDriver(options);
                driverlocal.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                driverlocal.manage().window().maximize();
                DriverFactory.driver.set(driverlocal);

            }
            return DriverFactory.driver.get();
}
}
