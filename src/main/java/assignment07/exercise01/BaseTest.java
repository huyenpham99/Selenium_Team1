package assignment07.exercise01;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public static  ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<>();

    public WebDriver getDriver(){
        return dr.get();
    }

    public void setWebDriver (RemoteWebDriver driver){
        dr.set(driver);
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        getDriver().quit();
        dr.set(null);
    }


    @Parameters({"platform","browser"})
    @BeforeTest
    public void isTest(String platform, String browser) throws IOException {

        DesiredCapabilities cap = new DesiredCapabilities();
        RemoteWebDriver driver =null;


        if(platform.equalsIgnoreCase("windows")){
            cap.setPlatform(Platform.WINDOWS);
        }

        if(platform.equalsIgnoreCase("mac")){
            cap.setPlatform(Platform.MAC);
        }


        if(browser.equalsIgnoreCase("internet explorer")){
            cap.setBrowserName("internet explorer");
            driver = new RemoteWebDriver(new URL("http://192.168.0.229:4444/wd/hub"),cap);

        }

        if(browser.equalsIgnoreCase("chrome")){
            cap.setBrowserName("chrome");
            driver = new RemoteWebDriver(new URL("http://192.168.0.229:4444/wd/hub"),cap);
        }

        if(browser.equalsIgnoreCase("firefox")){
            cap.setBrowserName("firefox");
            driver = new RemoteWebDriver(new URL("http://192.168.0.229:4444/wd/hub"),cap);
        }

        if(browser.equalsIgnoreCase("headless")){
            cap.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"D:\\phantomjs.exe");
            driver = new PhantomJSDriver(cap);

        }
        setWebDriver(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();


    }
}
