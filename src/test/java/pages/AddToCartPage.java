package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class AddToCartPage extends TestBase {

	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[class*='btn btn_primary']")
	List<WebElement> beforeClick;
	@FindBy(css = "button[class*='btn btn_secondary']")
	List<WebElement> afterClick;
	@FindBy(css = ".shopping_cart_link")
	WebElement CartItems;
	@FindBy(xpath = "//div[@class='cart_list']")
	List<WebElement> cartProducts;
	@FindBy(id = "checkout")
	WebElement checkOut;

	public String beforeAddingToCart() {		
		for (int i = 2; i < beforeClick.size(); i++) {
			beforeClick.get(i).click();
		}
		return beforeClick.get(0).getText();
	}
	public String afterAddingToCart() {
		return afterClick.get(0).getText();
	}
	public ArrayList<String> ProductAddedInCart() {
		CartItems.click();
		ArrayList<String> addedAtCart = new ArrayList<String>();
		for (WebElement  li: cartProducts) {
			addedAtCart.add(li.getText());
		}
		return addedAtCart;
	}
	public ArrayList<String> compareProductAddedToCart() {
		ArrayList<String> sort = new ArrayList<String>();   
		for(String s:ProductAddedInCart()){
			sort.add(s);
		}
		checkOut.click();
		return sort;
	}

}
