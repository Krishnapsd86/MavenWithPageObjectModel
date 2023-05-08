package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutPage extends TestBase{
	
	public CheckoutPage() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="first-name")
	WebElement name;
	@FindBy(id="last-name")
	WebElement lastname;
	@FindBy(id="postal-code")
	WebElement code;
	@FindBy(id="continue")
	WebElement submit;
	@FindBy(xpath="//div[@class='cart_item']")
	List<WebElement> CheckoutItems;
	@FindBy(css="div[class=\"inventory_item_price\"]")
	List<WebElement> total;
	@FindBy(css=".summary_tax_label")
	WebElement tax;
	@FindBy(css=".summary_info_label.summary_total_label")
	WebElement totalSum;
	@FindBy(id="finish")
	WebElement Finish;
	@FindBy(css=".complete-header")
	WebElement confirmatiomMsgs;
	
	public int fillForm() {
		name.sendKeys("Krishna");
		lastname.sendKeys("Test");
		code.sendKeys("1234");
		submit.click();
		return CheckoutItems.size();
	}
	public double TotalAmountWithTax() {
		double sum =0;
		for (int i = 0; i < total.size(); i++) { 
			String prices = total.get(i).getText();
			String priceValue = prices.replace("$", "");
			double price = Double.parseDouble(priceValue);
			sum = sum + price;
			
		}
		String taxlist =tax.getText();
		String taxLabel = taxlist.replace("Tax: $", "");
		double taxLabels = Double.parseDouble(taxLabel);
		sum = taxLabels + sum;
		return sum;
	}
	
	public double CheckoutTotalSum() {
		String TotalAmount =totalSum.getText();
		String Totsum = TotalAmount.replace("Total: $", "");
		double totalSummary = Double.parseDouble(Totsum);
		System.out.println("Total Summary $:"+totalSummary);
		return totalSummary;
	}
	public String ConfirmationMessage() {
		Finish.click();
		return confirmatiomMsgs.getText();

	}
	

}
