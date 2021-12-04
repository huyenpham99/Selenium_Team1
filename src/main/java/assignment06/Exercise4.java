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

public class Exercise4 {

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
    public void isExercise04() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(0).switchTo().frame(driver.findElement(By.name("frame-middle")));

        String middleFrameText = driver.findElement(By.cssSelector("[id='content']")).getText();
        Assert.assertTrue(middleFrameText.equalsIgnoreCase("MIDDLE"));

        driver.switchTo().parentFrame().switchTo().frame(driver.findElement(By.xpath("//*[@name='frame-left']")));
        String leftFrameText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(leftFrameText.contains("LEFT"));

        driver.switchTo().defaultContent().switchTo().frame(1);
        String bottomFrameText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bottomFrameText.contains("BOTTOM"));

    }
}
