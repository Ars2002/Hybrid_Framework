package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtils {
	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	private static final String reportPath = "target/extent-report.html";

	public static void initializeReport() {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().setDocumentTitle("Test Execution Report");
		sparkReporter.config().setReportName("TestNG Automation Report");

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
	}

	public static void createTest(String testName) {
		extentTest.set(extentReports.createTest(testName));
	}

	public static void logStepWithScreenshot(String message, WebDriver driver, String stepName) {
		String screenshotPath = ScreenshotUtils.captureScreenshot(driver, stepName);
		
		extentTest.get().info(stepName+" Screenshot attached: ",
				MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

	public static void finalizeReport() {
		extentReports.flush();
	}

	public static void logFail(String string) {
		extentTest.get().fail(string);
	}

	public static void attachScreenshot(String screenshotPath) {
		extentTest.get().addScreenCaptureFromPath(screenshotPath);

	}

	public static void logInfo(String messageString) {
		extentTest.get().info(messageString);
	}
}
