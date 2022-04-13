package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Base;
import utils.Locators;

public class ProductListPage  extends Base{

	WebDriverWait wait = new WebDriverWait(driver, 100);
	public ProductListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public ProductListPage goToURL(){
		openSite(Locators.baseURL);
		return this;
	}

	public ProductListPage addProductToCart(){
		clickElement(Locators.AddProductToCart1);
		clickElement(Locators.AddProductToCart2);
		
		return this;
	}

	public ProductListPage goToMyCart(){	
		clickElement(Locators.GoToMyCart);	
		
		return this;
	}

	public Boolean setPositiveAndNegativeQuantityInput(WebDriverWait wait) throws InterruptedException{		
		// Set a positive number
		sendText(Locators.QuantityMyCart, "5");		
		
		if( checkQuantityField() < 1) {
			return false;
		}
		// Set a negative number
		sendText(Locators.QuantityMyCart, "-5");		

		if( checkQuantityField() != 1) {
			return false;
		}
		
		return true;
	}

	public int checkQuantityField(){
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.QuantityMyCart));
		String val = e.getAttribute("value");

		return Integer.parseInt(val);
	}


}
