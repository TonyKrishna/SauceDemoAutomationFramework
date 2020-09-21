package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class ProductPage extends TestBase{

	@FindBy (xpath="//div[@id='shopping_cart_container']/a")
	WebElement cartLink;
	
	@FindBy (xpath="//div[@class='product_label']")
	WebElement productLabel;
	
	@FindBy (xpath="//div[@class='inventory_list']")
	WebElement inventoryList;
	
	@FindBy (xpath="//select[@class='product_sort_container']")
	WebElement sortByBox;
	
	@FindBy (xpath="(//div[@class='pricebar']/div)[1]")
	WebElement priceBarOfFirstElement;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean getProductLabelStatus() {
		return productLabel.isDisplayed();
	}
	
	public void clickCartIcon() {
		cartLink.click();
	}
	
	public void chooseAndViewProductPage(String itemName) {
		List<WebElement> itemList= driver.findElements(By.xpath("//div[@class='inventory_list']//a/div"));
		if (itemList.size()>0) {
			for (WebElement l: itemList) {
				if(l.getText().contentEquals(itemName)) {
					l.click();
					break;
				}
			}
		}
	}
	
	public void sortBy(String sortByText) {
		Select s = new Select(sortByBox);
		s.selectByVisibleText(sortByText);
	}
	
	public String getPriceOfFirstProduct() {
		return priceBarOfFirstElement.getText();
	}
	
	
	
}
