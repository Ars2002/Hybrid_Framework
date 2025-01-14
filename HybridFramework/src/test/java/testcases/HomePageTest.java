package testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;
import utils.ExcelUtils;

public class HomePageTest extends BaseTest{
	HomePage homePage ;
	RegisterPage registerPage;
	ExcelUtils excelUtils = new ExcelUtils("CustomerDetails.xlsx", "Register");
	
	@BeforeClass
	public void setUp() {
		initializeWebDriver();
	}
	
	@Test (priority = 1)
	public void validate_User_Landed_To_Home_Page() throws InterruptedException {
		homePage = new HomePage();
		Assert.assertTrue(homePage.urlLaunched());
		System.out.println("Logo displayed");
		homePage.openRegisterPage();
	}
	
	@Test (priority = 2)
	public void register_A_Customer() throws InterruptedException {
		registerPage = new RegisterPage();
		String actualString = registerPage.signUpHeading();
		String expectedString = "Signing up is easy!";
		Assert.assertEquals(expectedString, actualString);
		for(int i=1; i<excelUtils.getRowCount(); i++) {
			List<String> rowList = new ArrayList<String>();
			for(int j=0; j<excelUtils.getColumnCount(i); j++)
				rowList.add(excelUtils.getCellData(i, j));
			Thread.sleep(1000);
			registerPage.enterCustomerDetails(rowList);
		}
	}
	
	@AfterClass
	public void tearDown() {
		super.tearDown();
	}
}
