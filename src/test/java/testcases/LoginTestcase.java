package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;

public class LoginTestcase extends TestBase{
	
	static LoginPage loginPage;
	
	public LoginTestcase() {
		super();
	}
	@BeforeMethod
	public void startUp() throws IOException {
		SetUp();
		loginPage = new LoginPage();
	}
	
	@Test
	public void ValidLogin() {
		
		loginPage.loginPages();
		String expected =loginPage.DashBoardLogo();
		String actual = "Swag Labs";
		Assert.assertEquals(expected,actual);	
	}
	@Test
	public void InvalidLogin() {
		loginPage.Invalidlogin();
		String expected = loginPage.Invalidlogin();
		String actual = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(expected,actual);
		
	}
	@Test
	public void Title() {
		loginPage.LoginTitle();
		String expected =loginPage.LoginTitle();
		String actual = "Swag Labs";
		Assert.assertEquals(expected,actual);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}


}
