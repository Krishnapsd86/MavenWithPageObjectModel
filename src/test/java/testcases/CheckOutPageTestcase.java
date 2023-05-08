package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AddToCartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

public class CheckOutPageTestcase extends TestBase{
	LoginPage loginPage;
	ProductPage productPage;
	AddToCartPage addToCartPage;
	CheckoutPage checkoutPage;
	
	public CheckOutPageTestcase() {
		super();
	}
	@BeforeMethod
	public void startUp() throws IOException {
		SetUp();
		loginPage = new LoginPage();
		productPage = new ProductPage();
		addToCartPage = new AddToCartPage();
		checkoutPage = new CheckoutPage();
		
	}
	@Test
	public void FillOutForm() {
		loginPage.loginPages();
		productPage.ActualProductDisplay();
		addToCartPage.compareProductAddedToCart();
		checkoutPage.fillForm();
	}
	@Test
	public void CheckoutOverview() {
		loginPage.loginPages();
		productPage.ActualProductDisplay();
		addToCartPage.compareProductAddedToCart();
		checkoutPage.fillForm();
		double sum =checkoutPage.TotalAmountWithTax();
		double totalSummary =checkoutPage.CheckoutTotalSum();
		Assert.assertEquals(sum, totalSummary);
		
	}
	@Test
	public void validateConfirmationMessage() {
		loginPage.loginPages();
		productPage.ActualProductDisplay();
		addToCartPage.compareProductAddedToCart();
		checkoutPage.fillForm();
		String conMsgs =checkoutPage.ConfirmationMessage();
		Assert.assertTrue(conMsgs.equalsIgnoreCase("Thank you for your order!"));
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
