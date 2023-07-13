import BaseTest.Base;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class endToEndTest extends Base {
    String productName="ZARA COAT 3";

    @Test(dataProvider = "getData",groups = {"Purchase"})
    public void addToCartAndCheckout(HashMap<String,String> input) throws IOException {
        productCatalog pC = landingpage.loginToApplication(input.get("email"),input.get("password"));
        List<WebElement> we = pC.getProductText();
        cartLandingPage cp = pC.clickProduct(input.get("product"));

        cp.clickToCart();
        //Assert.assertEquals(cp.getTextOFTheProduct(product),product);

        payMentPage pp = cp.clickCheckOut();
        pp.inputYourCountryFiled("ind");

        oderConfirmationPage oc = pp.clickOnPlaceOrder();
        Assert.assertEquals(oc.getConfirmationGreetings(),"THANKYOU FOR THE ORDER.");

    }

    @Test(dependsOnMethods = "addToCartAndCheckout")
    public void OrderHistoryTest(){
        productCatalog pC = landingpage.loginToApplication("appledasare@gmail.com","Guruji6@");
        ordersPage op = pC.clickOnOrdersTab();
        Assert.assertTrue(op.getAllProductTextsFromOrdersTab(productName));
        //Assert.assertTrue(op.getAllProductTextsFromOrdersTab("asdas"));

    }
    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String,String>> hm = getjsonDataToMap(System.getProperty("user.dir")+"/src/test/java/data/PurchaseOrder.json");
        return new Object[][]{{hm.get(0)},{hm.get(1)}};
    }

    @DataProvider
    public Object[][] getDataPractrise() throws IOException{
        return new Object[][] {{"First-Value"}, {"Second-Value"}};
    }
 }
