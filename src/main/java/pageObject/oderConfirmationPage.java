package pageObject;

import Utils.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class oderConfirmationPage extends AbstractComponents {
    WebDriver driver;
    public oderConfirmationPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[@class='hero-primary']")
    WebElement ordeCOnfirmationText;

    public String getConfirmationGreetings(){
        return ordeCOnfirmationText.getText();
    }
}
