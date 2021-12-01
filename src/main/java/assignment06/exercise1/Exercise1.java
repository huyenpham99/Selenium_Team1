package assignment06.exercise1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;


public class Exercise1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//input[@id='alertbtn']/preceding-sibling::input")).sendKeys("HieuLD4");
        driver.findElement(By.cssSelector("#confirmbtn")).click();
        Assert.assertTrue(driver.switchTo().alert().getText().contains("HieuLD4"));
        driver.switchTo().alert().dismiss();
        driver.quit();



    }
}
