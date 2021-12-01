package assignment06.exercise4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Exercise4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(0).switchTo().frame(driver.findElement(By.name("frame-middle")));
        Assert.assertTrue(driver.findElement(By.cssSelector("[id='content']")).getText().equalsIgnoreCase("MIDDLE"));
        driver.switchTo().parentFrame().switchTo().frame(driver.findElement(By.xpath("//*[@name='frame-left']")));
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("LEFT"));
        driver.switchTo().defaultContent().switchTo().frame(1);
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("BOTTOM"));
        driver.quit();


    }
}
