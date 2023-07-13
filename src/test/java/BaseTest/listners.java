package BaseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReporterNg;

import java.io.IOException;

public class listners extends Base implements ITestListener {
        ExtentReports extent = ExtentReporterNg.getReportObject();
        ExtentTest test;

        @Override
        public void onTestStart(ITestResult result) {
            test = extent.createTest(result.getMethod().getMethodName());
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            ITestListener.super.onTestSuccess(result);
            test.log(Status.PASS,"Test Passed");
        }

        @Override
        public void onTestFailure(ITestResult result) {
            test.fail(result.getThrowable());
            String filePathOfScreenShot=null;
            test.fail(result.getThrowable());
            try {
                driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            try {
               filePathOfScreenShot = getScreenShot(result.getMethod().getMethodName(),driver);

            } catch (IOException e) {
                e.printStackTrace();
            }
            test.addScreenCaptureFromPath(filePathOfScreenShot,result.getMethod().getMethodName());

        }

        @Override
        public void onTestSkipped(ITestResult result) {
            ITestListener.super.onTestSkipped(result);
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
            ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        }

        @Override
        public void onTestFailedWithTimeout(ITestResult result) {
            ITestListener.super.onTestFailedWithTimeout(result);
        }

        @Override
        public void onStart(ITestContext context) {
            ITestListener.super.onStart(context);
        }

        @Override
        public void onFinish(ITestContext context) {
            extent.flush();
        }
}
