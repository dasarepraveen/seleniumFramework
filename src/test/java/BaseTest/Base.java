package BaseTest;

import Utils.config;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageObject.landingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class Base {
    public WebDriver driver;
    public landingPage landingpage;

    public WebDriver init() throws IOException {
        config configaccess = ConfigFactory.create(config.class);
        System.out.println("Browser is  "+configaccess.browser());
//        Properties prop = new Properties();
//        FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/GLobalVariables/config.properties");
//        prop.load(fip);
        //String browerName = prop.getProperty("browser");
        String browserName = System.getProperty("browser") != null ?
                System.getProperty("browser") : configaccess.browser();
        if(browserName.contains("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            if(browserName.contains("headless")){
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900));
            driver.getWindowHandles();
        }
        else if(browserName.equalsIgnoreCase("safari")){
            //safari code
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","/Users/praveendasare/Downloads/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configaccess.timeout()));
        return driver;
    }
    public List<HashMap<String,String>> getjsonDataToMap(String filePath) throws IOException {

        //JSON to String
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

        //String to HashMap using Jackson Bind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {
        });
        return data;

    }

    public String getScreenShot(String testCaseName,WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"/reports/"+testCaseName+".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
    }

    @BeforeMethod(alwaysRun = true)
    public landingPage launchApplication() throws IOException {
        driver = init();
        landingpage = new landingPage(driver);
        landingpage.goTo();
        return landingpage;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }

}
