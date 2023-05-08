package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class ProductPage extends TestBase {
	
	public ProductPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".inventory_item_name")
	List<WebElement> TotalProduct;
	@FindBy(css="#react-burger-menu-btn")
	WebElement NavBar;
	@FindBy(css="a[class='bm-item menu-item']")
	List<WebElement> ItemDisplay;
	@FindBy(css=".product_sort_container")
	WebElement Filter;
	@FindBy(xpath ="//*[@class=\"select_container\"]/select/option[1]")
	WebElement AtoZfilter;
	@FindBy(xpath ="//*[@class=\"select_container\"]/select/option[2]")
	WebElement ZtoAfilter;
	@FindBy(xpath ="//*[@class=\"select_container\"]/select/option[3]")
	WebElement LowToHigh;
	@FindBy(xpath ="//*[@class=\"select_container\"]/select/option[4]")
	WebElement HighToLow;
	
	
	
	
	public ArrayList<String> ActualProductDisplay() {
		ArrayList<String> AllList = new ArrayList<String>();
		for (int i = 0; i < TotalProduct.size(); i++) {
			AllList.add(TotalProduct.get(i).getText());	
		}
	     return AllList;
	}
	public ArrayList<String> FilterProductDisplay() {
		ArrayList<String> matchList = new ArrayList<String>();
		for(String s:ActualProductDisplay()){
			matchList.add(s);
		}
		return matchList;
	}
	public ArrayList<String> ListOfProductAtoZ() {
		Select option = new Select(Filter);
		AtoZfilter.click();
		ArrayList<String> obtainedList = new ArrayList<String>();
		for(WebElement we:TotalProduct){
			   obtainedList.add(we.getText());
			}
		return obtainedList;
	}
	public ArrayList<String> sortedProductAtoZ() {
		ArrayList<String> sortedList = new ArrayList<String>();
		for(String s:ListOfProductAtoZ()){
			sortedList.add(s);
			}
		Collections.sort(sortedList);
		return sortedList;
		
	}
	public ArrayList<String> ListOfProductZtoA() {
		Select option = new Select(Filter);
		AtoZfilter.click();
		ArrayList<String> obtainedList = new ArrayList<String>();
		for(WebElement we:TotalProduct){
			   obtainedList.add(we.getText());
			}
		return obtainedList;
	}
	public ArrayList<String> sortedProductZtoA() {
		ArrayList<String> sortedList = new ArrayList<String>();
		for(String s:ListOfProductZtoA()){
			sortedList.add(s);
			}
		Collections.sort(sortedList);
		//Collections.reverse(sortedList);
		return sortedList;
		
	}
	public ArrayList<String> ListOfProductLowToHigh() {
		Select option = new Select(Filter);
		AtoZfilter.click();
		ArrayList<String> obtainedList = new ArrayList<String>();
		for(WebElement we:TotalProduct){
			   obtainedList.add(we.getText());
			}
		return obtainedList;
	}
	public ArrayList<String> sortedProductLowToHigh() {
		ArrayList<String> sortedList = new ArrayList<String>();
		for(String s:ListOfProductLowToHigh()){
			sortedList.add(s);
			}
		Collections.sort(sortedList);
		Collections.reverse(sortedList);
		return sortedList;
		
	}
	public ArrayList<String> ListOfProductHighToLow() {
		Select option = new Select(Filter);
		AtoZfilter.click();
		ArrayList<String> obtainedList = new ArrayList<String>();
		for(WebElement we:TotalProduct){
			   obtainedList.add(we.getText());
			}
		return obtainedList;
	}
	public ArrayList<String> sortedProductHighToLow() {
		ArrayList<String> sortedList = new ArrayList<String>();
		for(String s:ListOfProductHighToLow()){
			sortedList.add(s);
			}
		Collections.sort(sortedList);
		Collections.reverse(sortedList);
		return sortedList;
		
	}

}
