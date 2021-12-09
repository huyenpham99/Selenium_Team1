package assignment08.DEMO.test;

import assignment08.DEMO.helper.DriverHelper;
import assignment08.DEMO.helper.JsonHelper;
import assignment08.DEMO.model.User;
import assignment08.DEMO.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {



    User user;

    @Test
    public void loginSuccessfully() {
        LoginPage loginPage;
        WebDriver driver = DriverHelper.getInstance().getWebDriver();
        loginPage = new LoginPage(driver);
        user = JsonHelper.getUserById(0);
        loginPage.login(user);
//        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(URL_ACCOUNT),"Failed to login");
    }

    @Test
    public void loginEmptyEmail() {
        WebDriver driver = DriverHelper.getInstance().getWebDriver();
        LoginPage loginPage3 = new LoginPage(driver);
        user = JsonHelper.getUserById(1);
        loginPage3.login(user);

//        String alertText = loginPage3.getAlertText();
//        Assert.assertEquals(alertText,"An email address required.");

    }

    @Test
    public void loginInvaliAcc() {
        WebDriver driver = DriverHelper.getInstance().getWebDriver();
        LoginPage loginPage2 = new LoginPage(driver);
        user = JsonHelper.getUserById(2);
        loginPage2.login(user);

//        String alertText = loginPage2.getAlertText();
//        Assert.assertEquals(alertText,"Authentication failed.");

    }
}
