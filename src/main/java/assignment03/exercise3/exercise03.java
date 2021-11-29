package assignment03.exercise3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class exercise03 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/");
        driver.findElement(By.xpath("(//*[@class='bui-group__item'])[5]/a")).click();
        driver.findElement(By.name("username")).sendKeys("hieuld4@gmail.com");
        driver.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@class='access-panel__social-buttons']/a[1]")).click();
        Thread.sleep(2000);
        driver.quit();
    }

}
