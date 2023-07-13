import BaseTest.Base;
import BaseTest.Retry;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.cartLandingPage;
import pageObject.productCatalog;

import java.util.List;

public class errorTest extends Base {
    @Test(groups = "negativeCases",retryAnalyzer = Retry.class)
    public void validateWrongproduct(){
        String productName="ZARA COAT 3";

        productCatalog pC = landingpage.loginToApplication("appledasare@gmail.com","Guruji6@");
        List<WebElement> we = pC.getProductText();
        cartLandingPage cp = pC.clickProduct(productName);

        cp.clickToCart();
        Assert.assertNotEquals(cp.getTextOFTheProduct(productName),"ZARA COAT 34");
    }
}
