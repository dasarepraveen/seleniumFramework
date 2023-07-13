package pageObject;

import Utils.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ordersPage extends AbstractComponents {
    WebDriver driver;
    public ordersPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//tbody /tr /td[2]")
    List<WebElement> orderstext;

    public boolean getAllProductTextsFromOrdersTab(String input){
        boolean value=false;
        for (WebElement el:orderstext)
        {
            if(el.getText().equalsIgnoreCase(input)){
                 value=true;
                 break;
        }
        }
        return value;
    }



}
