package CDP;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;

public class directCDPCOmmands {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools =  driver.getDevTools();
        devTools.createSession();
        Map emulation = new HashMap();
        emulation.put("width",600);
        emulation.put("height",1000);
        emulation.put("deviceScaleFactor",50);
        emulation.put("mobile",true);
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",emulation);
        driver.findElement(By.xpath("//button[@data-target=\"#navbarSupportedContent\"]")).click();
        driver.findElement(By.partialLinkText("Products")).click();
        Thread.sleep(3000);
    }
}
