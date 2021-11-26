package day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUpDriver {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Đi đến 1 url
        driver.navigate().to("https://anhtester.com");
        //Lấy Title và in ra console
        System.out.println(driver.getTitle());
//Lấy ra URL hiện tại
        System.out.println(driver.getCurrentUrl());
        //Close tab mà selenium mở ra
        driver.close();
        //Quit luôn trình duyệt
        driver.quit();
    }
}
