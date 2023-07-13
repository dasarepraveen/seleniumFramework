package pageObject;

import Utils.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class payMentPage extends AbstractComponents {
    WebDriver driver;

    public payMentPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement countryInput;

    @FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']/button")
    List<WebElement> dropDownValues;

    @FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
    WebElement placeAnOrder;

    public void inputYourCountryFiled(String input){
        countryInput.sendKeys(input);
        for (WebElement wee:dropDownValues) {
            //System.out.println("From the drop down "+wee.getText());
            if(wee.getText().equalsIgnoreCase("India")){
                wee.click();
                break;
            }

        }

    }
    public oderConfirmationPage clickOnPlaceOrder(){
        placeAnOrder.click();
        return new oderConfirmationPage(driver);

    }

}
