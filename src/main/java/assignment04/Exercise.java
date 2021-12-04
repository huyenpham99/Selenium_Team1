package assignment04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exercise {
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
    public void isExercise() {
        String email = "HieuLD4@gmail.com";
        String pass = "as123456";

        driver.get("http://demo.guru99.com/insurance/v1/index.php");

        //Login Page
        driver.findElement(By.cssSelector("a.btn.btn-default")).click();

        //Register Page
        dropdown(driver, By.id("user_title"), "Master");
        driver.findElement(By.name("firstname")).sendKeys("Hieu");
        driver.findElement(By.id("user_surname")).sendKeys("Le");
        driver.findElement(By.cssSelector("input#user_phone")).sendKeys("0369808166");

        dropdown(driver, By.id("user_dateofbirth_1i"), "1944");
        dropdown(driver, By.id("user_dateofbirth_2i"), "February");
        dropdown(driver, By.id("user_dateofbirth_3i"), "15");

        if (!driver.findElement(By.id("licencetype_f")).isSelected()) {
            driver.findElement(By.id("licencetype_f")).click();
        }

        dropdown(driver, By.id("user_licenceperiod"), "20");
        dropdown(driver, By.id("user_occupation_id"), "Physician");

        driver.findElement(By.xpath("//*[@id='user_address_attributes_street']")).sendKeys("123 Hang Bo");
        driver.findElement(By.name("city")).sendKeys("Ha Noi");
        driver.findElement(By.cssSelector("[name='county']")).sendKeys("100000");
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.name("c_password")).sendKeys(pass);
        driver.findElement(By.cssSelector("[value='Create']")).click();

        //Login Page
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.cssSelector("#password")).sendKeys(pass, Keys.ENTER);

        //Broker Insurance WebPage
        String actualResult = driver.findElement(By.xpath("//*[@class='button_to']/preceding-sibling::h4")).getText();
        Assert.assertTrue(actualResult.equalsIgnoreCase(email),"The email is displayed incorrectly");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public static void dropdown(WebDriver driver, By locator, String text) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }
}
