package assignment05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class Exercise3 {


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
    public void isExercise03(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions a = new Actions(driver);

        WebElement contextBtn = driver.findElement(By.cssSelector(".context-menu-one.btn.btn-neutral"));
        WebElement editBtn = driver.findElement(By.xpath("//*[contains(@class,'context-menu-icon-edit')]"));
        a.contextClick(contextBtn).click(editBtn).build().perform();

        try {
            BufferedImage src = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(src,"png", new File("javaassign5_ex3.png"));
            Thread.sleep(2000);
        } catch (AWTException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().alert().accept();


    }
}
