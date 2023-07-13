package CDP;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import java.util.Optional;

public class chromedevtools {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        DevTools devtool = driver.getDevTools();
        devtool.createSession();

        //Now call cdp protocols
        devtool.send(Emulation.setDeviceMetricsOverride(600,1000,50,true,
                Optional.empty(),Optional.empty()
        ,Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty()));
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[@data-target=\"#navbarSupportedContent\"]")).click();
        driver.findElement(By.partialLinkText("Products")).click();
        Thread.sleep(10000);
    }
}
