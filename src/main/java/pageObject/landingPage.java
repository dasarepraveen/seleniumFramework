package pageObject;

import Utils.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage extends AbstractComponents {
    WebDriver driver;
    public landingPage(WebDriver driver){
        super(driver);
        System.out.println("Prinitng inside landing page constructor");
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }
    @FindBy(id="userEmail")
    WebElement userName;

    @FindBy(id="userPassword")
    WebElement passWord;

    @FindBy(id="login")
    WebElement login;

    @FindBy(css = "[@class*='flyInOut']")
    WebElement loginError;

    public productCatalog loginToApplication(String username,String password){
        userName.sendKeys(username);
        passWord.sendKeys(password);
        login.click();
        return new productCatalog(driver);
    }

}
