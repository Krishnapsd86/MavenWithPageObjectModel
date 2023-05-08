package testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import pages.ProductPage;

public class ProductPageTestcase extends  TestBase{
	
	ProductPage productPage;
	LoginPage loginPage;
	
	public ProductPageTestcase() {
		super();
	}
	@BeforeMethod
	public void startUp() throws IOException {
		SetUp();
		loginPage = new LoginPage();
		productPage = new ProductPage();
	}
	
	@Test
	public void validateDisplayProduct() {
		loginPage.loginPages();
		ArrayList<String> actual =productPage.ActualProductDisplay();
		ArrayList<String> filter = productPage.FilterProductDisplay();
		Assert.assertEquals(actual, filter);
	}
	@Test
	public void validateSortProductAtoZ() {
		loginPage.loginPages();
		ArrayList<String> original =productPage.ListOfProductAtoZ();
		ArrayList<String> sorted =productPage.sortedProductAtoZ();
		Assert.assertTrue(sorted.equals(original));
	}
	@Test
	public void validateSortProductZtoA() {
		loginPage.loginPages();
		ArrayList<String> original =productPage.ListOfProductZtoA();
		ArrayList<String> sorted =productPage.sortedProductZtoA();
		Assert.assertTrue(sorted.equals(original));
	}
	@Test
	public void validateSortProductLowToHigh() {
		loginPage.loginPages();
		ArrayList<String> original =productPage.ListOfProductLowToHigh();
		ArrayList<String> sorted =productPage.sortedProductLowToHigh();
		Assert.assertNotEquals(original, sorted);
	}
	@Test
	public void validateSortProductHighToLOw() {
		loginPage.loginPages();
		ArrayList<String> original =productPage.ListOfProductHighToLow();
		ArrayList<String> sorted =productPage.sortedProductHighToLow() ;
		Assert.assertNotEquals(original, sorted);
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	

}
