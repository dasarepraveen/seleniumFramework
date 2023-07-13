package CDP;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.network.Network;
import org.openqa.selenium.devtools.v109.network.model.Request;
import org.openqa.selenium.devtools.v109.network.model.Response;

import java.util.Optional;

public class netwrokCalls {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools =  driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(),request->{
            System.out.println("request id is "+request.getRequestId());
            Request req = request.getRequest();
            System.out.println(req.getUrl());

        });
        devTools.addListener(Network.responseReceived(),response -> {
            Response res  = response.getResponse();
            //System.out.println(res.getUrl());
            System.out.println(res.getStatus());
            //response.getResponse().getStatus();
        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[text()=' Virtual Library ']")).click();

    }
}
