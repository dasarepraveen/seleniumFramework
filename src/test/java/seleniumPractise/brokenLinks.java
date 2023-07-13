package seleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class brokenLinks {
    public static void main(String[] args) throws InterruptedException, IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://open.spotify.com/");
        Thread.sleep(4000);
        //List<WebElement> ele = driver.findElements(By.tagName("a"));
        List<WebElement> ele = driver.findElements(By.xpath("//a"));
        for (WebElement links:ele) {
            String url = links.getAttribute("href");
            validUrl(url);
        }
        WebElement ese = driver.findElement(By.xpath("(//div[@data-encore-id=\"type\"])[3]"));
        System.out.println(ese.getAttribute("class"));

        driver.quit();
    }
    public static boolean validUrl(String validurl) throws IOException {
        URL url = new URL(validurl);
        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        httpURLConnection.connect();
        if(httpURLConnection.getResponseCode()>=400){
            System.out.println(validurl+ " "+ httpURLConnection.getResponseMessage());
            return true;
        }
        else {
            System.out.println(httpURLConnection.getResponseMessage());
            return false;
        }
    }

}
