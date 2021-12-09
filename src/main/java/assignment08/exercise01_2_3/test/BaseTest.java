package assignment08.exercise01_2_3.test;

import assignment08.exercise01_2_3.helper.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    public static final String URL_LOGIN = "http://automationpractice.com/index.php?controller=authentication";
    public static final String URL_ACCOUNT = "http://automationpractice.com/index.php?controller=my-account";
    public static final String URL_HOMEPAGE = "http://automationpractice.com/index.php";



    @BeforeMethod
    public void setUp(){
        DriverManager.getInstance().isWebDriver();
    }

    @AfterMethod
    public void tearDown(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DriverManager.getInstance().getWebDriver().quit();
    }

}
