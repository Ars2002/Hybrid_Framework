package base;

import java.time.Duration;
import java.lang.reflect.Method;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import utils.ReportManager;
import utils.ScreenshotUtils;

public class BaseTest {

	protected static WebDriver driver;
	protected static ExtentReports extentReports;
	protected static ExtentTest extentTest;
	protected static ScreenshotUtils screenshotUtils;

	@BeforeClass
	public static void setUp() {
		extentReports = ReportManager.getReportInstance();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(ConfigReader.getProperty("url"));
	}

	@AfterClass
	public static void tearDown() {
		extentReports.flush();
		if (driver != null) {
			driver.quit();
		}
	}
}