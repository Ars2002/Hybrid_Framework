package testcases;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;
import utils.ExcelUtils;

public class HomePageTest extends BaseTest{
	HomePage homePage = new HomePage();
	RegisterPage registerPage = new RegisterPage();
	ExcelUtils excelUtils = new ExcelUtils("D:\\Automation-Framework\\HybridFramework\\src\\test\\resources\\CustomerDetails.xlsx", "Register");
	
	@Test
	public void validate_User_Landed_To_Home_Page() throws InterruptedException {
		Assert.assertTrue(homePage.urlLaunched());
		homePage.openRegisterPage();
		Thread.sleep(2000);
	}
	
	@Test
	public void register_A_Customer() throws InterruptedException {
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
}
