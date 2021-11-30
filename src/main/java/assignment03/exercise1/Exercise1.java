package assignment03.exercise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class Exercise1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(" https://www.walmart.com/account/signup");
        driver.findElement(By.id("first-name-su")).sendKeys("First Name");
        driver.findElement(By.id("last-name-su")).sendKeys("Last Name");
        driver.findElement(By.xpath("//input[@id='email-su']")).sendKeys("phamhuyen123@gmail.com");
        driver.findElement(By.xpath("//input[@id='password-su']")).sendKeys("111Huyen@");
        driver.findElement(By.xpath("(//button[@data-tl-id='signup-submit-btn'])[1]")).submit();

    }
}
