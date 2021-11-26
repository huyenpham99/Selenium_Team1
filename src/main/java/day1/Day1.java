package day1;

import org.testng.annotations.*;

public class Day1 {

//    @Test
//    public void Demo1() {
//        System.out.println("Hello"); //automation
//    }
//
//    @Test
//    public void SecondTest() {
//        System.out.println("Bye");
//    }

    @Test
    public void testTest() {
        System.out.println("C");
    }

   // @Parameters({"parameterX"})
    @Test(dependsOnMethods = {"testTest", "testTest2"}, timeOut = 8000)
    public void testTest1( ){
        System.out.println("In parameter: ");
    }

    @Test(dataProvider = "thamso")
    public void testTest2(int a, int b) {
        System.out.println(a + " " + b);
    }

    @DataProvider
    public Object[][] thamso() {
        Object[][] arr = new Object[3][2];
        //[]1 số  lần lặp
        //[]2: lấy ra bao nhiêu giá trị trong một lần lặp
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[1][0] = 3;
        arr[1][1] = 2;
        arr[2][0] = 4;
        arr[2][1] = 5;
        return arr;
    }


}
