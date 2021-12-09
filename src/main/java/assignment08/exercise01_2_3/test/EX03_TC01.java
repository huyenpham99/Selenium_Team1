package assignment08.exercise01_2_3.test;


import assignment08.exercise01_2_3.helper.DriverManager;
import assignment08.exercise01_2_3.page.TopsPage;
import assignment08.exercise01_2_3.page.WomenPage;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class EX03_TC01 extends BaseTest {

    WomenPage womenPage;
    TopsPage topsPage;

    @Test
    public void EX03_TC01() {
        DriverManager.getInstance().getWebDriver().get(URL_HOMEPAGE);
        womenPage = new WomenPage();
        topsPage = new TopsPage();

        Assert.assertTrue(womenPage.getWomenItem().isDisplayed());

        womenPage.clickWomenItem();
        womenPage.checkDisplay();
        womenPage.clickSubcategory("tops");

        DriverManager.getInstance().getWebDriver().navigate().back();

        womenPage.checkDisplay();

        DriverManager.getInstance().getWebDriver().navigate().forward();

        topsPage.checkDisplay();

        womenPage.clickSubcategory("t-shirts");

        Set<Cookie> cookieSet = DriverManager.getInstance().getWebDriver().manage().getCookies();
    }

}
