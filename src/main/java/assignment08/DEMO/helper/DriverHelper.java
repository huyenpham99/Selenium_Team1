package assignment08.DEMO.helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverHelper {

    private static DriverHelper instance = null;

    public static DriverHelper getInstance(){
        if (instance == null){
            instance = new DriverHelper();
        }
        return instance;
    }


    private  ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public void setWebDriver (WebDriver driver){
        System.out.println(String.format("setWebDriver : %s - %s ", Thread.currentThread().getId(), driver.toString()));
        dr.set(driver);
    }

    public WebDriver getWebDriver (){
        System.out.println(String.format("getWebDriver : %s - %s ", Thread.currentThread().getId(), dr.get().toString()));
        return dr.get();
    }


    public synchronized WebDriver driverHelper(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
        driver.manage().window().maximize();
        setWebDriver(driver);
        return driver;
    }
}
