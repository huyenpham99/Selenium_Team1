package assignment06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exercise3 {


    private WebDriver driver;

    @BeforeMethod
    public void getWebDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        this.driver = driver;
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

    @Test
    public void isExercise03() {
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        driver.switchTo().frame("iframeResult").switchTo().frame(0);

        String text1 = driver.findElement(By.tagName("h1")).getText();
        Assert.assertTrue(text1.equals("This page is displayed in an iframe"));

        driver.switchTo().parentFrame();
        String text2 = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(text2,"HTML Iframes");

        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("[id='breadcrumb'] li:nth-of-type(3) a")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
