package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class WelcomePage extends BaseTest{
	@FindBy (xpath = "//div[@id='rightPanel']//p")
	WebElement welcomeMsgElement;
	
	public WelcomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//method to verify welcome message with username
	public String getWelcomeUserName() {
		return welcomeMsgElement.getText();
	}
}
