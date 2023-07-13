package pageObject;

import Utils.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class cartLandingPage extends AbstractComponents {
    WebDriver driver;

    public cartLandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement cart;

    @FindBy(xpath = "//div[@class='cartSection']/descendant::h3")
    List<WebElement> producTetxts;

    @FindBy(xpath = "//ul[@style='list-style-type: none;']/descendant::button")
    WebElement checkOut;

    public void clickToCart(){
        cart.click();
    }
    public String getTextOFTheProduct(String text){
        String validation=null;
        for (WebElement name:producTetxts)
        {
            if(name.getText().equalsIgnoreCase(text)){
                validation=text;
                break;
            }
        }
        return validation;
    }

    public payMentPage clickCheckOut(){
        checkOut.click();
        return new payMentPage(driver);
    }
}
