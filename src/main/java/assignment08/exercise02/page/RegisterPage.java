package assignment08.exercise02.page;

import assignment08.exercise02.model.Visitor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    @FindBy(id = "email_create")
    WebElement emailCreate;

    @FindBy(css = "#SubmitCreate")
    WebElement createBtn;

    @FindBy(css = "#create_account_error li")
    WebElement alertText;

    @FindBy(css = ".account_creation:nth-of-type(1) > h3")
    WebElement titleText;

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void create(String email){
        emailCreate.sendKeys(email, Keys.ENTER);
    }

    public String getAlertText(){
        return alertText.getText();
    }

    public String getTitleText(){
        return titleText.getText();
    }
}
