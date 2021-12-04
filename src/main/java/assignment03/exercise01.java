package assignment03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class exercise01 {

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
    public void quit(){
        driver.quit();
    }

    @Test
    public void isExercise01(){
        driver.get("https://www.walmart.com/account/signup");
        driver.findElement(By.cssSelector("#first-name-su")).sendKeys("Hieu");
        driver.findElement(By.id("last-name-su")).sendKeys("Le");
        driver.findElement(By.xpath("//*[@id='email-su']")).sendKeys("HieuLD4@gmail.com");
        driver.findElement(By.cssSelector("input#password-su")).sendKeys("as123456");

        WebElement signInCheckBox = driver.findElement(By.cssSelector("[for='remember-me-su'] > span"));
        if(!signInCheckBox.isSelected()){
            signInCheckBox.click();
        }

        WebElement emailCheckBox = driver.findElement(By.cssSelector("[for='su-newsletter']"));
        if(!emailCheckBox.isSelected()){
            emailCheckBox.click();
        }

        Assert.assertTrue(driver.findElement(By.xpath("(//*[@data-tl-id='signup-submit-btn'])[1]")).isEnabled());

        driver.findElement(By.xpath("//*[@data-automation-id='signup-sign-in-btn']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
