package assignment1.exercise1;

import org.testng.annotations.*;

public class Test2 {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is before method");
    }

    @Test
    public void testCase2() {
        System.out.println("This is test case 2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is after method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is after class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is after test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("this is after suite");
    }
}
