package assignment07;

import static org.openqa.selenium.support.locators.RelativeLocator.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exercise03 {

    private WebDriver driver;

    @BeforeClass
    public void getWebDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        this.driver = driver;
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }

    @Test
    public void isExercise03(){
        driver.get("http://automationpractice.com/index.php?controller=contact");
        WebElement subHeading = driver.findElement(By.id("id_contact"));
        Select select = new Select(subHeading);
        select.selectByVisibleText("Customer service");

        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Customer service");

        WebElement emailLabel = driver.findElement(By.cssSelector("[for='email']"));
        driver.findElement(with(By.tagName("input")).below(emailLabel)).sendKeys("HieuLD4@gmail.com");

        WebElement orderLabel = driver.findElement(By.cssSelector("[for='fileUpload']"));
        driver.findElement(with(By.tagName("input")).above(orderLabel)).sendKeys("123456789");

        driver.findElement(By.id("message")).sendKeys("This is a complaint");

        driver.findElement(By.cssSelector("#submitMessage")).click();

        String text = driver.findElement(By.cssSelector(".alert.alert-success")).getText();

        Assert.assertTrue(text.equalsIgnoreCase("Your message has been successfully sent to our team."));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
