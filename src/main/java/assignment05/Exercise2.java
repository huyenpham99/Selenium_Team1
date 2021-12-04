package assignment05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

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
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions a = new Actions(driver);
        a.doubleClick(driver.findElement(By.xpath("//*[@ondblclick='myFunction()']"))).build().perform();
        BufferedImage src = null;
        try {
            src = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(src,"png", new File("assign5_ex2.png"));
            Thread.sleep(2000);
        } catch (AWTException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();
        driver.quit();
    }
}
