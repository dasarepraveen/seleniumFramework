package pageObject;

import Utils.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class productCatalog extends AbstractComponents {

    WebDriver driver;

    public productCatalog(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//div[@class='container']/descendant::h5/b")
    List<WebElement> productText;

    @FindBy(id="toast-container")
    WebElement toast;

    By productBy = By.xpath("//div[@class='container']/descendant::h5/b");

    By addtoCartOfAProduct = By.xpath("(//button[@class='btn w-10 rounded'])[1]");

    public List<WebElement> getProductText(){
        WaitUntilVisisbilityOfElement(productBy);
        return productText;
    }

    public WebElement getProductsByName(String name){
        WebElement coat =null;
        for (WebElement el:productText) {
            System.out.println("texts are "+el.getText());
            if(el.getText().equalsIgnoreCase("ZARA COAT 3")){
                System.out.println("+++++++++++++Its inside");
                coat=el;
            }
        }
        return coat;
    }

    public cartLandingPage clickProduct(String productname){
        WebElement el = getProductsByName(productname);
        el.findElement(addtoCartOfAProduct).click();
        WaitUntilInvisibiltyOfElement(toast);
        return new cartLandingPage(driver);

    }


}
