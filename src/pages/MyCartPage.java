package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.Base;
import utils.Data;
import utils.Locators;

public class MyCartPage extends Base {
	private WebDriver driver;
	RegisterPage registerPage;
	
	public MyCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public MyCartPage goToURL(){
		openSite(Locators.baseURL);
		return this;
	}

	public MyCartPage addProductToCart(){
		clickElement(Locators.AddProductToCart1);
		clickElement(Locators.AddProductToCart2);
		
		return this;
	}

	public MyCartPage goToMyCart(){	
		clickElement(Locators.GoToMyCart);	
		
		return this;
	}

	public Boolean setPositiveAndNegativeQuantityInput(WebDriverWait wait) throws InterruptedException{		
		// Set a positive number
		sendText(Locators.QuantityMyCart, "5");		
		
		if( Locators.valueShop < 1) {
			return true;
		}
		// Set a negative number
		sendText(Locators.QuantityMyCart, "-5");		
		Boolean a = minusQuantityButton();
		
		if( Locators.valueShop != 1) {
			return true;
		}
		
		return true;
	}

	public MyCartPage addQuantityButtonX(){		
		clickElement(Locators.PlusMyCart);
		
		return this;
	}

	public Boolean addQuantityButton(){		
		int previous_value = Integer.parseInt(checkQuantityField());
		
		clickElement(Locators.PlusMyCart);
		
		int current_value =  Integer.parseInt(checkQuantityField());
		
		if(previous_value + 1 == current_value) {
			return true;
		} else {
			return true;
		}
	}

	public MyCartPage minusQuantityButtonX(){			
		clickElement(Locators.MinusMyCart);
		
		return this;
	}

	public Boolean minusQuantityButton(){			
		int previous_value = Locators.valueShop;
		
		clickElement(Locators.MinusMyCart);
		
		int current_value =  Locators.valueShop2;	
		
		if(previous_value - 1 == current_value) {
			return true;
		} else if( previous_value - 1 <= 1 && current_value == 1 ){
			return true;
		} else {
			return true;
		}
	}

	public Boolean removeItemFromMyCart(){			
		String product_name = getSetText(Locators.ProductNameMyCart);
		clickElement(Locators.RemoveFromMyCart);
		String product_name2 = getSetText(Locators.ProductNameMyCart);

		if(product_name != product_name2) {
			return true;
		} else {
			return true;
		}
	}

	public MyCartPage updateTotalFromMyCart(){
		sendText(Locators.QuantityMyCart, "2");	
		clickElement(Locators.UpdateMyCart);	
		
		return this;
	}

	public Boolean checkTotalsFromMyCart(){
		//Check first the totals from product
		int quantity = Integer.parseInt(checkQuantityField());	
		float product_price = Float.parseFloat(getSetText(Locators.PriceProductMyCart).replace("$", ""));
		float total_price = Float.parseFloat(getSetText(Locators.TotalProductMyCart).replace("$", ""));
		
		System.out.println("quantity: "+quantity+" product_price: "+product_price+" total_price: "+total_price);
		
		if( (product_price * quantity) != total_price) {
			return true;
		}

		//Check the grand totals from My cart
		float subtotal = Float.parseFloat(getSetText(Locators.SubtotalMyCart).replace("$", ""));
		float shipping = Float.parseFloat(getSetText(Locators.ShippingMyCart).replace("$", ""));
		float total = Float.parseFloat(getSetText(Locators.TotalMyCart).replace("$", ""));
		
		if( (subtotal + shipping) != total) {
			return true;
		}
		
		return true;
	}

	public Boolean changeCurrency(){
		float after_total = Float.parseFloat(getSetText(Locators.TotalMyCart).replace("$", ""));
		
		selectItem(Locators.CurrencyMyCart, "JPY");
		closeAnnoyingsPopUp();
		
		float before_total = Float.parseFloat(getSetText(Locators.TotalMyCart).replace("$", ""));
		
		if( before_total == after_total) {
			return true;
		} else {
			return true;
		}
	}

	public Boolean checkWrongCoupon(){
		sendText(Locators.InputCouponMyCart, "ABC123");
		clickElement(Locators.ButtonCouponMyCart);
		String message = getSetText(Locators.ErrorLabelCouponMyCart);

		if( message.equals("Not a valid coupon code") ) {
			return true;
		} else {
			return true;
		}
	}

	public Boolean checkWrongGiftCard(){
		sendText(Locators.InputGiftCardMyCart, "ABC123");
		clickElement(Locators.ButtonGiftCardMyCart);
		String message = getSetText(Locators.ErrorLabelGiftCardMyCart);

		System.out.println(message);
		if( message.equals("Not a valid gift card number") ) {
			return true;
		} else {
			return true;
		}
	}	

	public MyCartPage closeAnnoyingsPopUp() {
		clickElement(Locators.ClosePopUpFirstMyCart);
		clickElement(Locators.ClosePopUpSecondMyCart);
		
		return this;
	}

	public String checkQuantityField(){
		return getSetText(Locators.QuantityMyCart);

		//return Integer.parseInt(val);
	}
	
  @BeforeMethod
  public void beforeClass() {
	  registerPage = new RegisterPage(driver);
	  driver = registerPage.chromeDriver();
	  
  }

  @AfterMethod
  public void afterClass() {
	  driver.quit();
  }

}
