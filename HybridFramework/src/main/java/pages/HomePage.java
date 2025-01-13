package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class HomePage extends BaseTest{
	@FindBy (xpath = "//div[@id='topPanel']/a[2]/img")
	WebElement parabankLogoElement;
	
	@FindBy (xpath = "//div[@id='loginPanel']/p[2]/a")
	WebElement registerElement;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean urlLaunched() {
		return parabankLogoElement.isDisplayed();
	}
	
	public void openRegisterPage() {
		registerElement.click();
		System.out.println("Clicked on register link");
	}
}
