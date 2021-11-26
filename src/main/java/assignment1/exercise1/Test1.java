package assignment1.exercise1;

import org.testng.annotations.*;

public class Test1 {

    @BeforeClass
    public void beforeSuite() {
        System.out.println("This is before suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is before test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is before class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is before method");
    }

    @Test
    public void testCase1() {
        System.out.println("This is test case 1");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is after method");
    }



}
