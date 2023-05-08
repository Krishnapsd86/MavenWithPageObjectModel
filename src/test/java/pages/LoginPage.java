package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="user-name")
	WebElement userName;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="login-button")
	WebElement login;
	@FindBy(tagName ="h3")
	WebElement errorMsgs;
	@FindBy(css=".header_label")
	WebElement DashboardLogo;
	
	
	public ProductPage loginPages() {
		
		userName.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		login.click();
		return new ProductPage();
		
	}
	
	public String Invalidlogin() {
		userName.sendKeys("standard");
	    password.sendKeys("secret_sauce");
		login.click();
		return errorMsgs();
		
		
	}
	public String errorMsgs() {
		return errorMsgs.getText();
	}
	
	public String LoginTitle() {
		return driver.getTitle();
	}
	
	public String DashBoardLogo() {
		return DashboardLogo.getText();
	}


	

}
