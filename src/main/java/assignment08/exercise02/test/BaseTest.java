package assignment08.exercise02.test;

import assignment08.exercise02.helper.DriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    final String URL_CREATE = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @BeforeMethod
    public void setUp(){
        DriverHelper.driverHelper().get(URL_CREATE);
    }

    @AfterMethod
    public void tearDown(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DriverHelper.getWebDriver().quit();
        DriverHelper.setWebDriver(null);
    }

}
