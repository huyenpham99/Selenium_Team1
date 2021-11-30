package assignment05.exercise4;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;
import java.util.Set;

public class Exercise4 {
    public static void main(String[] args) throws InterruptedException {
        File file = new File("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie:cookies) {
            System.out.println(cookie.getName());
        }
        Thread.sleep(2000);
        driver.quit();

    }
}
