package assignment08.exercise01_2_3.test;

import assignment08.exercise01_2_3.helper.DriverManager;
import assignment08.exercise01_2_3.helper.JsonHelper;
import assignment08.exercise01_2_3.model.VisitorEmail;
import assignment08.exercise01_2_3.page.Create_LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EX02_TC04_RegisterWithExistingEmail extends BaseTest {

    Create_LoginPage createLoginPage;
    VisitorEmail visitorEmail = JsonHelper.getInstance().getEmail(0);

    @Test
    public void EX02_TC04_RegisterWithExistingEmail() {
        DriverManager.getInstance().getWebDriver().get(URL_LOGIN);
        createLoginPage = new Create_LoginPage();
        createLoginPage.create(visitorEmail);

        String expectedText = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
        Assert.assertEquals(createLoginPage.getCreateAlertText(), expectedText);
    }

}
