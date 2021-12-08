package assignment08.exercise02.helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverHelper {
    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setWebDriver(WebDriver driver){
        dr.set(driver);
    }

    public static WebDriver getWebDriver(){
        return dr.get();
    }

    public static WebDriver driverHelper(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        setWebDriver(driver);
        return driver;
    }
}
