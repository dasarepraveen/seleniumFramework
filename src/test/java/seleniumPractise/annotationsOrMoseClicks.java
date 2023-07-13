package seleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class annotationsOrMoseClicks {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        Actions act = new Actions(driver);
        //driver.findElement(By.id("email")).click();
        //act.keyDown(Keys.SHIFT).sendKeys("praveen").build().perform();
        act.moveToElement(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
        Thread.sleep(2000);
        act.contextClick().perform();
        Thread.sleep(2000);
        act.moveToElement(driver.findElement(By.xpath("//ul[contains(@class,'context')]/li/span[text()=\"Edit\"]"))).perform();
        act.click();
        Thread.sleep(2000);

        driver.quit();
    }
}
