package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import data.LoginDataFile;
import pages.LoginPage;
import pages.ProductPage;

public class LoginPageTests extends TestBase {
	
	LoginPage loginPage;
	ProductPage productPage;
	LoginDataFile df= new LoginDataFile();
	
	public LoginPageTests(){
		super();
	}

	@BeforeMethod
	public void setUp() {
		initBrowser();
		loginPage = new LoginPage();	
	}
	
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}
	
	@Test(priority=1)
	public void loginPageValidationTest() {
		boolean logoDisplayed = loginPage.getLoginPageLogoStatus();
		Assert.assertTrue(logoDisplayed);		
	}
	
	@Test(priority=2)
	public void loginAsStandardUser() {
		String uname = prop.getProperty("standard_username");
		String pwd = prop.getProperty("password");
		loginPage.validLogin(uname, pwd);
		productPage = new ProductPage();
		Assert.assertTrue(productPage.getProductLabelStatus());
	}
	
	@Test(priority=3)
	public void loginAsLockoutUser() {
		loginPage.validLogin(df.lockoutUsername, df.lockoutUserPass);
		String errMsg = loginPage.getLoginErrorMsg();
		Assert.assertEquals(errMsg, df.lockoutUserErrMsg);
	}
	
	@Test(priority=4)
	public void loginAsInvalidUser() {
		loginPage.validLogin(df.InvalidUsername, df.InvalidUserPass);
		String errMsg = loginPage.getLoginErrorMsg();
		Assert.assertEquals(errMsg, df.InvalidUserErrMsg);
	}
	

}
