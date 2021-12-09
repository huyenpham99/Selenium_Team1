package assignment08.exercise01_2_3.test;

import assignment08.exercise01_2_3.helper.DriverManager;
import assignment08.exercise01_2_3.helper.JsonHelper;
import assignment08.exercise01_2_3.model.User;
import assignment08.exercise01_2_3.page.Create_LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EX01_TC02_LoginWithInvalidAcc extends BaseTest {

    User user = JsonHelper.getInstance().getUserById(2);
    Create_LoginPage createLoginPage;

    @Test
    public void EX01_TC02_LoginWithInvalidAcc() {

        DriverManager.getInstance().getWebDriver().get(URL_LOGIN);
        createLoginPage = new Create_LoginPage();
        createLoginPage.login(user);

        String loginAlertText = createLoginPage.getLoginAlertText();
        Assert.assertEquals(loginAlertText, "Authentication failed.");

    }

}
