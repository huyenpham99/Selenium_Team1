package assignment05.exercise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.time.Duration;

public class Exercise1 {
    public static void main(String[] args) throws InterruptedException {
        File file = new File("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        Actions a = new Actions(driver);
        a.dragAndDrop(driver.findElement(By.xpath("(//*[@id='fourth'])[1]")),driver.findElement(By.cssSelector("#amt7"))).build().perform();
        Thread.sleep(2000);
        driver.quit();
    }

}
