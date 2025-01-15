package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String stepName) {
        // Create a timestamp for unique screenshot names
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotPath =  System.getProperty("user.dir") + "/target/screenshots/" + stepName + "_" + timestamp + ".png";

        // Take a screenshot and save it to the specified path
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(screenshotPath);

        try {
            Files.createDirectories(Paths.get("target/screenshots")); // Ensure directory exists
            Files.copy(source.toPath(), destination.toPath());
        } catch (IOException e) {
            System.err.println("Error while capturing screenshot: " + e.getMessage());
        }

        return screenshotPath;
    }
}
