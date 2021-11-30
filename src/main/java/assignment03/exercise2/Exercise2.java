package assignment03.exercise2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/*
Using browser tools for inspecting elements and page structure:
1. Write Hit the URL: https://www.walmart.com/ip/VIZIO-70-Class-4K-UHD-LED-SmartCast-Smart-TV-
HDR-V-Series-V705-G3/936515428 in Chrome browser.
2. Write the selectors of element by Id, Name, Class, XPath as below:
- Title product
- Price of product
- Free shipping info
- None tab, 2 Year tab
- Qty combobox
- Add to Cart button
- Add to list
- Add to Registry
 */
public class Exercise2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("");
    }
}
