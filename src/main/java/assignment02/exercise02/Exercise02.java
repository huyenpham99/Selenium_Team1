package assignment02.exercise02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Exercise02 {

    public static void main(String[] args) {
        File file = new File("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
        SoftAssert sa = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://tiki.vn/");
        sa.assertTrue(driver.getTitle().contains("tiki.vn"));
        driver.close();
        sa.assertAll();


    }

}
