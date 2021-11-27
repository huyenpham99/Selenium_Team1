package assignment01.exercise02;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckPassFail {

    @Parameters("mark")
    @Test
    public void checkPassFail(int mark){
        if(mark >= 50){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
    }

}
