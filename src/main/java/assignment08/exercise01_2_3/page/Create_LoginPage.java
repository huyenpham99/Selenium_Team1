package assignment08.exercise01_2_3.page;



import assignment08.exercise01_2_3.model.User;
import assignment08.exercise01_2_3.model.VisitorEmail;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@NoArgsConstructor
public class Create_LoginPage extends BasePage {


    //Login Elements
    @FindBy(id = "email")
    WebElement loginEmail;

    @FindBy(id = "passwd")
    WebElement loginPass;

    @FindBy(xpath = "//*[@name='SubmitLogin']")
    WebElement loginBtn;

    @FindBy(xpath = "//*[@class='alert alert-danger']//li")
    WebElement loginAlert;


    //Create ELements
    @FindBy(id = "email_create")
    WebElement createEmail;

    @FindBy(css = "#SubmitCreate")
    WebElement createBtn;

    @FindBy(css = "#create_account_error li")
    WebElement createAlert;

    @FindBy(css = ".account_creation:nth-of-type(1) > h3")
    WebElement createTitle;


    public void login(User user) {
        loginEmail.sendKeys(user.getEmail());
        loginPass.sendKeys(user.getPassword());
        loginBtn.click();
    }

    public String getLoginAlertText()  {

        return loginAlert.getText();
    }



    public void create(VisitorEmail visitorEmail) {
        createEmail.sendKeys(visitorEmail.getEmail());
        createBtn.click();
    }

    public String getCreateAlertText(){

        return createAlert.getText();
    }

    public String getCreateTitleText(){

        return createTitle.getText();
    }
}
