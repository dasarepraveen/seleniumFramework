package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//play around with tags of the feature file to run only those
@CucumberOptions(features = "src/test/java/cucumber",glue = "stepDefinantion",monochrome = true,tags = "@regression",
        plugin = {"html:target/cucumber.html"})
public class TestNgCucumberTestRunner extends AbstractTestNGCucumberTests {
}
