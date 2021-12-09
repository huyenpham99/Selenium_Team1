package assignment08.exercise01_2_3.page;

import assignment08.exercise01_2_3.helper.DriverManager;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@NoArgsConstructor
public class WomenPage extends  BasePage {

    @FindAll(@FindBy(xpath = "//*[@class='subcategory-image']/.."))
    List<WebElement> subcategories;

    @FindAll(@FindBy(xpath = "//*[@class='subcategory-image']/..//h5/a"))
    List<WebElement> subcategoryName;




    public void clickSubcategory(String name){
        for (WebElement element :subcategoryName) {
            if (element.getText().equalsIgnoreCase(name)){
                element.click();
                break;
            }
        }

    }


    public void checkDisplay(){

        for (int i=0; i<subcategories.size();i++) {

            String display = String.valueOf(js.executeScript("return typeof(arguments[0]) != 'undefined' && arguments[0] != null;", subcategories.get(i)));

            if(display.equalsIgnoreCase("false")){

                sa.assertTrue(false);

                System.out.println(subcategoryName.get(i).getText()+" is not displayed");

            }
        }
        sa.assertAll();
    }


}
