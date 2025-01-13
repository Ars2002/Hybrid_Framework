package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	public static String takeScreenshot(WebDriver driver, String testName) {
		TakesScreenshot tScreenshot = (TakesScreenshot) driver;
		File srcFile = tScreenshot.getScreenshotAs(OutputType.FILE);
		String timeStampString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String destPathString = "target/screenshots/" + testName + "_" + timeStampString + ".png";

		File destFile = new File(destPathString);
		destFile.getParentFile().mkdirs();

		try {
			Files.copy(srcFile.toPath(), destFile.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destPathString;
	}
}
