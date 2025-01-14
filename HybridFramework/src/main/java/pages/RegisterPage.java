package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class RegisterPage extends BaseTest{
	WebDriver driver;
	
	@FindBy (xpath = "//div[@id='rightPanel']/h1")
	WebElement signupHeadingElement;
	
	@FindBy (xpath = "//form[@id='customerForm']")
	WebElement registrationTablElement;
	
	@FindBy (xpath = "//form[@id='customerForm']//input")
	List<WebElement> rowsElements;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String signUpHeading() {
		return signupHeadingElement.getText();
	}
	
	public void enterCustomerDetails(List<String> rowData) {
		for(int i=0; i<rowsElements.size()-1; i++) {
			rowsElements.get(i).sendKeys(rowData.get(i));
		}
	}
}
