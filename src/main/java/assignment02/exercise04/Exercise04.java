package assignment02.exercise04;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Exercise04 {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "D:\\Webdriver\\msedgedriver.exe");
        SoftAssert sa = new SoftAssert();
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.lazada.vn/");
        sa.assertTrue(driver.getTitle().contains("LAZADA"));
        driver.close();
        sa.assertAll();
    }
}
