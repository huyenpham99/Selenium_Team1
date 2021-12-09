package assignment08.exercise01_2_3.test;

import assignment08.exercise01_2_3.helper.DriverManager;
import assignment08.exercise01_2_3.helper.JsonHelper;
import assignment08.exercise01_2_3.model.VisitorEmail;
import assignment08.exercise01_2_3.page.Create_LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EX02_TC03_RegisterWithBlankEmail extends BaseTest {

    Create_LoginPage createLoginPage;
    VisitorEmail visitorEmail = JsonHelper.getInstance().getEmail(2);

    @Test
    public void EX02_TC03_RegisterWithBlankEmail() {
        DriverManager.getInstance().getWebDriver().get(URL_LOGIN);
        createLoginPage = new Create_LoginPage();
        createLoginPage.create(visitorEmail);

        String expectedText = "Invalid email address.";
        Assert.assertEquals(createLoginPage.getCreateAlertText(), expectedText);
    }

}
