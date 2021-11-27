package assignment01.exercise01;

import org.testng.annotations.*;

public class Exercise01 {



    @BeforeSuite
    public void beforeSuite(){

        System.out.println("I will be executed before test suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I will run before test folder");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("I run before class Day01");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I run before every test method in class Day01");
    }

    @Test
    public void testcase01(){
        System.out.println("I am testcase 01");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I run after every test method in class Day01");
    }



    @BeforeMethod
    public void beforeMethod02(){
        System.out.println("I run before every test method in class Day01 (02)");
    }


    @Test
    public void testcase02(){
        System.out.println("I am testcase 02");
    }

    @AfterMethod
    public void afterMethod02(){
        System.out.println("I run after every test method in class Day01 (02)");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I run after class Day01");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("I will run before test folder");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("I will be executed after test suite");
    }
}
