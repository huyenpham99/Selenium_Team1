package assignment08.DEMO.page;


import assignment08.DEMO.model.User;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Setter
public class LoginPage {

    @FindBy(id = "email")
    WebElement emailTextBox;

    @FindBy(name = "q")
    WebElement googleTextBox;

    @FindBy(id = "passwd")
    WebElement passTextBox;

    @FindBy(xpath = "//*[@name='SubmitLogin']")
    WebElement submitBtn;

    @FindBy(xpath = "//*[@class='alert alert-danger']//li")
    WebElement alertText;

    WebDriver driver;

    public LoginPage(WebDriver driver) {
//        DriverHelper.getInstance().getWebDriver()
        System.out.println("Login PAge : " + driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(User user) {
        System.out.println(String.format("Thread : %s", Thread.currentThread().getId()));
        System.out.println("login use driver : " + this.driver.toString());
//        System.out.println("login use driver : " + DriverHelper.getInstance().getWebDriver().hashCode());
//        System.out.println(this.driver.getPageSource());
//        System.out.println(emailTextBox.getText());


        googleTextBox.sendKeys(user.getEmail(), Keys.ENTER);




//        emailTextBox.sendKeys(user.getEmail());
//        passTextBox.sendKeys(user.getPassword());
//        submitBtn.click();

    }

    public String getAlertText()  {

        return alertText.getText();
    }
}
