import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.landingPage;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.time.Duration;
import java.util.List;

public class addToCartFlow {
public static void main(String[] args){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    //landingPage lg = new landingPage(driver);



    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
    driver.get("https://rahulshettyacademy.com/client");
    driver.findElement(By.id("userEmail")).sendKeys("appledasare@gmail.com");
    driver.findElement(By.id("userPassword")).sendKeys("Guruji6@");
    driver.findElement(By.id("login")).click();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1000));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container']/descendant::h5/b")));
    List<WebElement> we = driver.findElements(By.xpath("//div[@class='container']/descendant::h5/b"));
    WebElement coat =null;
    for (WebElement el:we) {
        System.out.println("texts are "+el.getText());
        if(el.getText().equalsIgnoreCase("ZARA COAT 3")){
            System.out.println("+++++++++++++Its inside");
            coat=el;
        }
    }
    //driver.findElement(with(By.tagName("label")).above(el)).getText())
    //System.out.println("Button name "+driver.findElement(with(By.tagName("button")).below(coat)).getText());

    coat.findElement(By.xpath("(//button[@class='btn w-10 rounded'])[1]")).click();
    WebElement toast = driver.findElement(By.id("toast-container"));
    wait.until(ExpectedConditions.invisibilityOf(toast));

    driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
    Assert.assertEquals(driver.findElement(By.xpath("//div[@class='cartSection']/descendant::h3")).getText(),"ZARA COAT 3");
    driver.findElement(By.xpath("//ul[@style='list-style-type: none;']/descendant::button")).click();

    driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
    List<WebElement> el = driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button"));
    for (WebElement wee:el) {
        //System.out.println("From the drop down "+wee.getText());
        if(wee.getText().equalsIgnoreCase("India")){
            wee.click();
            break;
        }

    }
    driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
    Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText(),"THANKYOU FOR THE ORDER.");


}
}
