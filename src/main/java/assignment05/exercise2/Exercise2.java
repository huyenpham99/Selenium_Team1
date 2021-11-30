package assignment05.exercise2;

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

public class Exercise2 {
    public static void main(String[] args) throws AWTException, IOException, InterruptedException {
        File file = new File("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions a = new Actions(driver);
        a.doubleClick(driver.findElement(By.xpath("//*[@ondblclick='myFunction()']"))).build().perform();
        BufferedImage src = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(src,"png", new File("assign5_ex2.png"));
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.quit();
    }
}
