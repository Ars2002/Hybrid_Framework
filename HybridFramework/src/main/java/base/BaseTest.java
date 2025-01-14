package base;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import utils.ReportManager;
import utils.ScreenshotUtils;

public class BaseTest {

	protected static WebDriver driver;
	protected static ExtentReports extentReports;
	protected static ExtentTest extentTest;
	protected static ScreenshotUtils screenshotUtils;

	public void initializeWebDriver() {
		extentReports = ReportManager.getReportInstance();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(ConfigReader.getProperty("url"));
		System.out.println(driver.getCurrentUrl());
	}

	

	public void tearDown() {
		extentReports.flush();
		if (driver != null) {
			driver.quit();
		}
	}
}
