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
import java.util.Iterator;
import java.util.Set;

public class exercise03 {

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
        driver.get("https://www.booking.com");
        driver.findElement(By.cssSelector("a[class*='header-login']:nth-child(1)")).click();
        driver.findElement(By.name("username")).sendKeys("HieuLD4@gmail.com");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.navigate().back();
        driver.findElement(By.cssSelector("[class*='facebook']")).click();

        Set<String> id = driver.getWindowHandles();
        Iterator<String> iterator = id.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();

        driver.switchTo().window(childId);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
