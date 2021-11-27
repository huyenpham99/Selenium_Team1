package assignment02.exercise03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Exercise03 {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","D:\\Webdriver\\geckodriver.exe");
        SoftAssert sa = new SoftAssert();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        sa.assertTrue(driver.getTitle().contains("Amazon.com"));
        driver.close();
        sa.assertAll();


    }

}
