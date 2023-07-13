package seleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class complexXpaths {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","/Users/praveendasare/Downloads/abcdas/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://open.spotify.com/");
        List<WebElement> ele = driver.findElements(By.xpath("//div[@class='I3EivnXTjYMpSbPUiYEg contentSpacing']/descendant::div[@class='E1N1ByPFWo4AJLHovIBQ']/a[@title]"));
        Thread.sleep(4000);
        for (WebElement links:ele) {
            System.out.println(links.getText());
        }
        driver.quit();
    }
}
