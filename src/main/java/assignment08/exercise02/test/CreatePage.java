package assignment08.exercise02.test;

import assignment08.exercise02.helper.DriverHelper;
import assignment08.exercise02.page.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePage extends BaseTest {

    RegisterPage registerPage;


    @Test
    public void isRegisteredEmail(){
        WebDriver driver = DriverHelper.getWebDriver();
        registerPage = new RegisterPage(driver);
        registerPage.create("hieul453@gmail.com");

        String expectedText = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
        Assert.assertEquals(registerPage.getAlertText().trim(),expectedText);
    }

    @Test
    public void isInvalidEmail(){
        WebDriver driver = DriverHelper.getWebDriver();
        registerPage = new RegisterPage(driver);
        registerPage.create("asdfasdfads");

        String expectedText = "Invalid email address.";
        Assert.assertEquals(registerPage.getAlertText().trim(),expectedText);
    }

    @Test
    public void isBlankEmail(){
        WebDriver driver = DriverHelper.getWebDriver();
        registerPage = new RegisterPage(driver);
        registerPage.create("");

        String expectedText = "Invalid email address.";
        Assert.assertEquals(registerPage.getAlertText().trim(),expectedText);
    }

    @Test
    public void isValidEmail(){
        WebDriver driver = DriverHelper.getWebDriver();
        registerPage = new RegisterPage(driver);
        registerPage.create("hieul453.01@gmail.com");

        String expectedText = "Your personal information";
        Assert.assertEquals(registerPage.getTitleText().trim(),expectedText.toUpperCase());
    }

}
