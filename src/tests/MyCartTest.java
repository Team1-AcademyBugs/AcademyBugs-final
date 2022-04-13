package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.MyCartPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class MyCartTest {
	WebDriverWait wait;
	private WebDriver driver;
	MyCartPage myCartPage;
	@Test
	  public void myCartTest() throws InterruptedException {

		  SoftAssert softAssertion = new SoftAssert();
		  
		  Boolean responsePositiveAndNegativeQuantityInput = myCartPage
				  .goToURL()			  
				  .addProductToCart()
				  .goToMyCart()
				  .setPositiveAndNegativeQuantityInput(wait);

			//TC 9
		  Boolean responseMinusQuantityButton = myCartPage
				  .goToURL()			  
				  .addProductToCart()
				  .goToMyCart()
				  .addQuantityButtonX()
				  .minusQuantityButton();
		  
			//TC 10
		  /*Boolean responseAddQuantityButton = myCartPage
				  .goToURL()			  
				  .addProductToCart()
				  .goToMyCart()
				  .addQuantityButton();*/
		  
			//TC 11
		  /*Boolean responseRemoveItemFromMyCart = myCartPage
				  .goToURL()			  
				  .addProductToCart()
				  .goToMyCart()
				  .removeItemFromMyCart();
		  
		  Boolean responseUpdateAndCheckMyCart = myCartPage
				  .goToURL()			  
				  .addProductToCart()
				  .goToMyCart()
				  .updateTotalFromMyCart()
				  .closeAnnoyingsPopUp()
				  .checkTotalsFromMyCart();*/
		  
		  Boolean responseChangeCurrency = myCartPage
				  .goToURL()			  
				  .addProductToCart()
				  .goToMyCart()
				  .changeCurrency();
		  
		  Boolean responseCheckWrongCoupon = myCartPage
				  .goToURL()			  
				  .addProductToCart()
				  .goToMyCart()
				  .checkWrongCoupon();
		  
		  Boolean responseCheckWrongGiftCard = myCartPage
				  .goToURL()			  
				  .addProductToCart()
				  .goToMyCart()
				  .checkWrongGiftCard();
			

		  softAssertion.assertTrue(responsePositiveAndNegativeQuantityInput);
		  softAssertion.assertTrue(responseMinusQuantityButton);
		  softAssertion.assertTrue(responseChangeCurrency);
		  softAssertion.assertTrue(responseCheckWrongCoupon);
		  softAssertion.assertTrue(responseCheckWrongGiftCard);
		  softAssertion.assertAll();
		  
	  }
  @BeforeMethod
  public void beforeMethod() {
	  myCartPage = new MyCartPage(driver);
	  driver = myCartPage.chromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
