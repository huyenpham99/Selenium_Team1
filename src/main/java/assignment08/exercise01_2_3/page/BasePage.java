package assignment08.exercise01_2_3.page;

import assignment08.exercise01_2_3.helper.DriverManager;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

@Getter
@Setter
public class BasePage {


    @FindBy (css = "[class*='menu-content'] a[title='Women']")
    WebElement womenItem;


    JavascriptExecutor js;
    SoftAssert sa;

    public BasePage() {

        js = (JavascriptExecutor) DriverManager.getInstance().getWebDriver();
        sa = new SoftAssert();
        PageFactory.initElements(DriverManager.getInstance().getWebDriver(), this);
    }

    public void clickWomenItem(){
        js.executeScript("arguments[0].click()",womenItem);
    }
}
