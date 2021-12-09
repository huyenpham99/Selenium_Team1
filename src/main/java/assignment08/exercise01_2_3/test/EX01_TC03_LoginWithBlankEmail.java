package assignment08.exercise01_2_3.test;

import assignment08.exercise01_2_3.helper.DriverManager;
import assignment08.exercise01_2_3.helper.JsonHelper;
import assignment08.exercise01_2_3.model.User;
import assignment08.exercise01_2_3.page.Create_LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EX01_TC03_LoginWithBlankEmail extends BaseTest {

    User user = JsonHelper.getInstance().getUserById(1);
    Create_LoginPage createLoginPage;

    @Test
    public void EX01_TC03_LoginWithBlankEmail() {
        DriverManager.getInstance().getWebDriver().get(URL_LOGIN);
        createLoginPage = new Create_LoginPage();
        createLoginPage.login(user);

        String alertText = createLoginPage.getLoginAlertText();
        Assert.assertEquals(alertText, "An email address required.");

    }
}
