package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import pages.ProductPage;
import utilities.TestUtil;

public class ProductPageTests extends TestBase{
	
	LoginPage loginPage;
	ProductPage productPage;
	TestUtil util;
	
	public ProductPageTests() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initBrowser();
		loginPage = new LoginPage();
		productPage = new ProductPage();
		util = new TestUtil();
		loginPage.validLogin(prop.getProperty("standard_username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}
	
	@Test(priority=1)
	public void validateProductPage() {
		Assert.assertTrue(productPage.getProductLabelStatus()); 
	}
	@Test(priority=2)
	public void clickOnProduct() throws IOException {
		String itemName = prop.getProperty("itemName");
		productPage.chooseAndViewProductPage(itemName);
		
	}
	@Test(priority=3)
	public void sortByPriceLowToHigh() throws IOException {
		productPage.sortBy(prop.getProperty("SortByTextLowToHigh"));
		String priceofProduct = productPage.getPriceOfFirstProduct();
		//util.takeScreenshot();
		Assert.assertEquals(priceofProduct, prop.getProperty("LowestPriceOfProduct"));
		
	}

}
