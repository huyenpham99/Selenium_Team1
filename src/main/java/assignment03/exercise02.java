package assignment03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class exercise02 {

    private WebDriver driver;

    @BeforeMethod
    public void getWebDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        this.driver = driver;
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }

    @Test
    public void isExercise02(){
        driver.get("https://www.walmart.com/ip/VIZIO-70-Class-4K-UHD-LED-SmartCast-Smart-TV-HDR-V-Series-V705-G3/936515428");
        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println(title.getText());
        WebElement price = driver.findElement(By.cssSelector("[class='flex flex-column'] span[itemprop='price']"));
        Assert.assertTrue(price.isDisplayed());
        System.out.println(driver.findElement(By.cssSelector(".flex.mt3.lh-copy .b.black")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Add to list']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Add to list']")).isEnabled());
        driver.findElement(By.xpath("//*[text()='Add to registry']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
