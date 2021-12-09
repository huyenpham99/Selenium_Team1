package assignment08.DEMO.test;

import assignment08.DEMO.helper.DriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    public static final String URL_LOGIN = "http://automationpractice.com/index.php?controller=authentication";
    public static final String URL_ACCOUNT = "http://automationpractice.com/index.php?controller=my-account";

    @BeforeMethod
    public void setUp() {

        DriverHelper.getInstance().driverHelper().get("https://google.com");
        System.out.println(String.format("setUp : %s ", Thread.currentThread().getId()) );
//        System.out.println(String.format("setUp h: %s ", DriverHelper.getInstance().getWebDriver().getCurrentUrl()) );

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        DriverHelper.getInstance().getWebDriver().close();
//        DriverHelper.getInstance().setWebDriver(null);
    }


}
