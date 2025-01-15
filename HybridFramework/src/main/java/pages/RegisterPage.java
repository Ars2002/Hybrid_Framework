package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import utils.ReportUtils;

public class RegisterPage extends BaseTest{
	
	@FindBy (xpath = "//div[@id='rightPanel']/h1")
	WebElement signupHeadingElement;
	
	@FindBy (xpath = "//form[@id='customerForm']")
	WebElement registrationTablElement;
	
	@FindBy (xpath = "//form[@id='customerForm']//input")
	List<WebElement> rowsElements;
	
	@FindBy(xpath = "//form[@id='customerForm']//b")
	List<WebElement> rowsLabelElements;
	
	@FindBy (xpath = "//form[@id='customerForm']//input[@value='Register']")
	WebElement registerBtnElement;
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String signUpHeading() {
		return signupHeadingElement.getText();
	}
	
	public void enterCustomerDetails(List<String> rowData) {
		for(int i=0; i<rowsElements.size()-1; i++) {
			String rowLableNameString = rowsLabelElements.get(i).getText();
			
			//generating a random username so that test will not get an error while registering a customer.
			if (rowLableNameString.equals("Username:")) {
				Random random = new Random();
				int randomIntInRange = random.nextInt(100);
				int randomIntInRange2 = random.nextInt(100);
				ReportUtils.logInfo("Entering "+rowLableNameString+" as "+rowData.get(i)+randomIntInRange+"_"+randomIntInRange2);
				rowsElements.get(i).sendKeys(rowData.get(i)+randomIntInRange+"_"+randomIntInRange2);
				continue;
			}
			
			rowsElements.get(i).sendKeys(rowData.get(i));
			ReportUtils.logInfo("Entering "+rowLableNameString+" as "+rowData.get(i));
		}
	}
	
	public WelcomePage registerCustomer() throws InterruptedException {
		registerBtnElement.click();
		System.out.println("clicked on register button");
		Thread.sleep(2000);
		return new WelcomePage();
	}
}
