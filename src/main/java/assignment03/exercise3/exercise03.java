package assignment03.exercise3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class exercise03 {
    public static void main(String[] args) {
        File file = new File("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/");
        driver.findElement(By.xpath("(//*[@class='bui-group__item'])[5]/a")).click();
        driver.findElement(By.name("username")).sendKeys("hieuld4@gmail.com");
        driver.findElement(By.cssSelector("[type='submit']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@class='access-panel__social-buttons']/a[1]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
