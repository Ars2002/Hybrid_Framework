package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class HomePage extends BaseTest{
//	@FindBy (xpath = "//div[@id='topPanel']/a[2]/img")
//	WebElement parabankLogoElement;
	
//	@FindBy (xpath = "//div[@id='loginPanel']/p[2]/a")
//	WebElement registerElement;
	
//	public HomePage() {
//		PageFactory.initElements(driver, this);
//	}
	
	public boolean urlLaunched() {
		System.out.println("URL Launched");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(parabankLogoElement));
		WebElement parabankLogoElement = driver.findElement(By.xpath("//div[@id='topPanel']/a[2]/img"));
		return parabankLogoElement.isDisplayed();
	}
	
	public void openRegisterPage() {
		WebElement registerElement = driver.findElement(By.xpath("//div[@id='loginPanel']/p[2]/a"));
		registerElement.click();
		System.out.println("Clicked on register link");
	}
}
