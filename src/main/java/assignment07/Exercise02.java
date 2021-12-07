package assignment07;

import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Exercise02 {
    ThreadLocal<WebDriver> dr = new ThreadLocal<>();
    DesiredCapabilities cap = new DesiredCapabilities();

    public void setWebDriver(WebDriver driver) {
        dr.set(driver);
    }

    public WebDriver getWebDriver() {
        return dr.get();
    }

    @BeforeMethod
    public void beforeMethod() {
        cap.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "D:\\phantomjs.exe");
        WebDriver driver = new PhantomJSDriver(cap);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        setWebDriver(driver);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        getWebDriver().quit();
        dr.set(null);
    }

    @Test
    public void testGooglePageTitleInChrome() {
        getWebDriver().get("https://google.com");
        String pageTitle = getWebDriver().getTitle();
        Assert.assertTrue(pageTitle.equalsIgnoreCase("google"), "Page title doesnt match");

    }

    @Test
    public void testSearchGoogle() {
        getWebDriver().get("https://google.com");
        getWebDriver().findElement(By.name("q")).sendKeys("Selenium Easy Grid Tutorials");
        getWebDriver().findElement(By.name("q")).submit();

    }
}
