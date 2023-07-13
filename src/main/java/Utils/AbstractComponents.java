package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.ordersPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class AbstractComponents {
    WebDriver driver;

    public AbstractComponents(WebDriver driver){
        this.driver=driver;
        System.out.println("Prinitng inside abstract construcutor constructor");
    }

    @FindBy(xpath = " //button[@routerlink='/dashboard/myorders'] ")
    WebElement order;


    public void WaitUntilVisisbilityOfElement(By ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
    }
     public void WaitUntilInvisibiltyOfElement(WebElement ele){
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.invisibilityOf(ele));

     }
     public ordersPage clickOnOrdersTab(){
        order.click();
        return new ordersPage(driver);
     }

    /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container']/descendant::h5/b")));*/

}
