package assignment04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.time.Duration;

public class Exercise {
    public static void main(String[] args) {

        String email = "HieuLD4@gmail.com";
        String pass = "as123456";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Actions a = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/");

        //Homepage
        driver.findElement(By.xpath("//*[text()='Insurance Project']")).click();

        //Login Page
        driver.findElement(By.cssSelector("a.btn.btn-default")).click();

        //Register Page
        dropdown(driver, "user_title", "Master", "Master");
        driver.findElement(By.name("firstname")).sendKeys("Hieu");
        driver.findElement(By.id("user_surname")).sendKeys("Le");
        driver.findElement(By.cssSelector("input#user_phone")).sendKeys("0369808166");

        dropdown(driver, "user_dateofbirth_1i", "1944", "1944");
        dropdown(driver, "user_dateofbirth_2i", "2", "February");
        dropdown(driver, "user_dateofbirth_3i", "15", "15");

        if (!driver.findElement(By.id("licencetype_f")).isSelected()) {
            driver.findElement(By.id("licencetype_f")).click();
        }

        dropdown(driver, "user_licenceperiod", "20", "20");
        dropdown(driver, "user_occupation_id", "16", "Physician");

        driver.findElement(By.xpath("//*[@id='user_address_attributes_street']")).sendKeys("123 Hang Bo");
        driver.findElement(By.name("city")).sendKeys("Ha Noi");
        driver.findElement(By.cssSelector("[name='county']")).sendKeys("100000");
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.name("c_password")).sendKeys(pass);
        driver.findElement(By.cssSelector("[value='Create']")).click();

        //Login Page
        a.sendKeys(driver.findElement(By.id("email")),email).
                sendKeys(driver.findElement(By.cssSelector("#password")),pass).sendKeys(Keys.ENTER).build().perform();

        //Broker Insurance WebPage
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='button_to']/preceding-sibling::h4")).
                getText().equalsIgnoreCase(email),"The email is incorrect");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }

    public static void dropdown(WebDriver driver, String id, String value, String expectResult) {
        WebElement dropdown = driver.findElement(By.id(id));
        Select select = new Select(dropdown);
        select.selectByValue(value);
        Assert.assertTrue(select.getFirstSelectedOption().getText().equalsIgnoreCase(expectResult));
    }
}
