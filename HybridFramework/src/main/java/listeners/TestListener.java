package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ReportUtils;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        ReportUtils.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReportUtils.logStepWithScreenshot("Test passed successfully.", (WebDriver) result.getTestContext().getAttribute("driver"), result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        driver = (WebDriver) result.getTestContext().getAttribute("driver");
        String screenshotPath = ScreenshotUtils.captureScreenshot(driver, result.getMethod().getMethodName());
        ReportUtils.logFail("Test failed: " + result.getThrowable().getMessage());
        ReportUtils.attachScreenshot(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ReportUtils.logFail("Test skipped: " + result.getThrowable().getMessage());
    }

    @Override
    public void onStart(ITestContext context) {
        ReportUtils.initializeReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        ReportUtils.finalizeReport();
    }
}
