package assignment05.exercise3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Exercise3 {
    public static void main(String[] args) throws AWTException, IOException, InterruptedException {
        File file = new File("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions a = new Actions(driver);
        a.contextClick(driver.findElement(By.cssSelector(".context-menu-one.btn.btn-neutral"))).click(driver.findElement(By.xpath("//*[contains(@class,'context-menu-icon-edit')]"))).build().perform();
        BufferedImage src = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(src,"png", new File("assign5_ex3.png"));
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.quit();

    }
}
