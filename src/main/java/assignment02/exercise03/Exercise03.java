package assignment02.exercise03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Exercise03 {

    public static void main(String[] args) {
        File file = new File("geckodriver.exe");
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
        SoftAssert sa = new SoftAssert();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        sa.assertTrue(driver.getTitle().contains("Amazon.com"));
        driver.close();
        sa.assertAll();


    }

}
