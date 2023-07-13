package stepDefinantion;

import BaseTest.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObject.*;

import java.io.IOException;
import java.util.List;

public class stepDefinantionImplementation extends Base {
    public landingPage landingpage;
    public productCatalog pC;;
    public cartLandingPage cp;
    public payMentPage pp;

    @Given("I landed on the BasePage")
    public void I_Land_On_The_BasePage() throws IOException {
        landingpage = launchApplication();
    }

    @Given("^Logged in with (.+) and (.+)$")
    public void Loggedin_With_UserNmae_Password(String userName,String passWord){
        pC = landingpage.loginToApplication(userName,passWord);
    }

    @When("^I add (.+) to the cart$")
    public void I_Add_Product_TO_The_Cart(String product){
        List<WebElement> we = pC.getProductText();
        cp = pC.clickProduct(product);
        cp.clickToCart();
        //Assert.assertEquals(cp.getTextOFTheProduct(product),product);
    }

    @And("I Check out the Product with relevent inputs")
    public void I_Checkout_The_Product(){
        pp = cp.clickCheckOut();
        pp.inputYourCountryFiled("ind");
    }

    @Then("Verify that the {string} message is displayed")
    public void Verify_The_Order_Message(String message){
        oderConfirmationPage oc = pp.clickOnPlaceOrder();
        Assert.assertEquals(oc.getConfirmationGreetings(),message);
        driver.close();
    }

    @And("I verify that the (.+) is not equal to actualname$")
    public void verify_product_name_isNot_What_it_Should_Be_like(String productCode){
        Assert.assertNotEquals(cp.getTextOFTheProduct(productCode),"ZARA COAT 34");
    }

}
