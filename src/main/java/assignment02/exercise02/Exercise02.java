package assignment02.exercise02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Exercise02 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\chromedriver.exe");
        SoftAssert sa = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://tiki.vn/");
        sa.assertTrue(driver.getTitle().contains("tiki.vn"));
        driver.close();
        sa.assertAll();


    }

}
