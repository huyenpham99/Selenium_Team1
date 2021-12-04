package assignment02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exercise01 {

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
    public void close(){
        driver.close();
    }

    @Test
    public void isExercise01(){
        driver.get("https://tiki.vn/");
        driver.findElement(By.cssSelector("[data-view-id='main_search_form_input']")).sendKeys("tủ", Keys.ENTER);
        driver.findElement(By.xpath("(//*[@class='product-item'])[1]")).click();
        WebElement title = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(title.isDisplayed());
        WebElement price = driver.findElement(By.cssSelector(".product-price__current-price"));
        Assert.assertTrue(price.isDisplayed());
    }



}
