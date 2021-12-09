package assignment08.exercise01_2_3.helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class DriverManager {

    private static DriverManager instance;

    private DriverManager() {}

    public static synchronized DriverManager getInstance(){

        if(instance == null){
            instance = new DriverManager();
        }
        return instance;
    }


    private ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public void setWebDriver(WebDriver driver){
        dr.set(driver);
    }

    public WebDriver getWebDriver(){
        return dr.get();
    }



    public WebDriver isWebDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        setWebDriver(driver);
        return driver;
    }






}
