package assignment02.exercise01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Exercise01 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","D:\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions a = new Actions(driver);
        SoftAssert sa = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://tiki.vn/");
        a.sendKeys(driver.findElement(By.cssSelector("[type='text']")),"tủ").sendKeys(Keys.ENTER).build().perform();
        driver.findElement(By.xpath("(//*[contains(@class,'style__StyledItem-sc')])[1]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("h1.title")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product-price__current-price']")).isDisplayed());
        driver.close();



    }

}
