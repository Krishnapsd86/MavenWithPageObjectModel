package testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AddToCartPage;
import pages.LoginPage;
import pages.ProductPage;

public class AddToCartTestcase extends TestBase{
	LoginPage loginPage;
	ProductPage productPage;
	AddToCartPage addToCartPage;
	
	public AddToCartTestcase() {
		super();
	}
	@BeforeMethod
	public void startUp() throws IOException {
		SetUp();
		loginPage = new LoginPage();
		productPage = new ProductPage();
		addToCartPage = new AddToCartPage();
		
	}
	@Test
	public void ValidateBeforeAfterAddButton() {
		loginPage.loginPages();
		productPage.ActualProductDisplay();
		String beforeClick =addToCartPage.beforeAddingToCart();
		String clickedButton =addToCartPage.afterAddingToCart();
		Assert.assertNotEquals(clickedButton, beforeClick);
	}
	
	@Test
	public void ValidateProductAddedToCart(){
		loginPage.loginPages();
		productPage.ActualProductDisplay();
		ArrayList<String> added =addToCartPage.ProductAddedInCart();
		ArrayList<String> verify =addToCartPage.compareProductAddedToCart();
		Assert.assertEquals(added.size(),verify.size());
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
