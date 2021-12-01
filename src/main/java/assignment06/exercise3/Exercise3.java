package assignment06.exercise3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Exercise3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        driver.switchTo().frame("iframeResult").switchTo().frame(0);
        Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().equals("This page is displayed in an iframe"));
        driver.switchTo().parentFrame();
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"HTML Iframes");
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("[id='breadcrumb'] li:nth-of-type(3) a")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
