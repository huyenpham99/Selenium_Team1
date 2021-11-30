package assignment02.exercise04;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Exercise04 {
    public static void main(String[] args) {
        File file = new File("msedgedriver.exe");
        System.setProperty("webdriver.edge.driver",file.getAbsolutePath());
        SoftAssert sa = new SoftAssert();
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.lazada.vn/");
        sa.assertTrue(driver.getTitle().contains("LAZADA"));
        driver.close();
        sa.assertAll();
    }
}
