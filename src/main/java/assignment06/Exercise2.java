package assignment06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Exercise2 {

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
    public void isExercise02() {

        driver.get("https://the-internet.herokuapp.com/windows");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        links.forEach(s->openLink(s));

        Set<String> id = driver.getWindowHandles();

        id.forEach(s -> getTitle(s));

    }

    public void openLink(WebElement element){
        element.sendKeys(Keys.CONTROL,Keys.ENTER);
    }

    public void getTitle(String id){
        driver.switchTo().window(id);
        System.out.println(driver.getTitle());
    }
}
