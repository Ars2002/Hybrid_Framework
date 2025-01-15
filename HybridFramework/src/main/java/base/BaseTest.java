package base;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import utils.ReportUtils;

public class BaseTest {

	protected static WebDriver driver;

	public void initializeWebDriver(ITestContext context) {
		
		ReportUtils.initializeReport();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		context.setAttribute("driver", driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(ConfigReader.getProperty("url"));
		System.out.println(driver.getCurrentUrl());
	}

	

	public void tearDown() {
		ReportUtils.finalizeReport();
		if (driver != null) {
			driver.quit();
		}
	}
}
