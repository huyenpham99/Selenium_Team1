package assignment1.exercise2;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Scanner;

public class CheckPassFail {
    @Parameters("mark")
    @Test
    public void checkPassFail(int mark) {
        if (mark>50){
            System.out.println("PASS");
        }else System.out.println("FAIL");
    }
}
