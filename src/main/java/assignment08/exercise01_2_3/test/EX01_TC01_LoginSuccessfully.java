package assignment08.exercise01_2_3.test;


import assignment08.exercise01_2_3.helper.DriverManager;
import assignment08.exercise01_2_3.helper.JsonHelper;
import assignment08.exercise01_2_3.model.User;
import assignment08.exercise01_2_3.page.Create_LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EX01_TC01_LoginSuccessfully extends BaseTest{

    User user = JsonHelper.getInstance().getUserById(0);
    Create_LoginPage createLoginPage;


    @Test
    public void EX01_TC01_LoginSuccessfully() {

        DriverManager.getInstance().getWebDriver().get(URL_LOGIN);
        createLoginPage = new Create_LoginPage();
        createLoginPage.login(user);

        String currentUrl = DriverManager.getInstance().getWebDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl,URL_ACCOUNT);
    }

}
