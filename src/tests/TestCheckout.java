package tests;

import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.ProductsPage;
import pages.ShippingPage;


import org.testng.annotations.BeforeMethod;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestCheckout {
	WebDriver driver;
	String PATH_DRIVER = "C:\\Users\\juan.gomez\\eclipse-workspace\\Team1-AcademyBugs\\chromedriver.exe";
	String TYPE_DRIVER = "webdriver.chrome.driver";
	String URL = "https://academybugs.com/find-bugs/";
	
	ProductsPage products;
	CheckoutPage checkout;
	ShippingPage shipping;
	@Test
	public void checkoutValid() {
		/* 
		 * TC0018
		 * DESCRIPTION: All fields filled with valid data, user completes checkout step
		 * EXPECTED RESULT: Success
		 */		
		products.addProduct();
		products.viewCartPage();
		products.redirectCheckout();		
		checkout.fillMainForm("Mexico", "Juan", "Perez", "Softtek" ,"Dummy street" , "Victoria", "Tamaulipas", "87078", "8341234567", "juan@mail.com");		
		try {
			Assert.assertEquals("Shipping Information", shipping.getLabel());
			System.out.println("TC0018 Passed");
		} catch (Exception e) {
			System.out.println("TC0018 Failed" + e);
		}
	}
	
	@Test
	public void checkoutInvalid() {
		/* 
		 * TC0019
		 * DESCRIPTION: Missing required fields, user must get an error message
		 * EXPECTED RESULT: Failure
		 */		
		products.addProduct();
		products.viewCartPage();
		products.redirectCheckout();		
		checkout = new CheckoutPage(driver);
		checkout.fillMainForm("Mexico", "", "Perez", "Softtek" ,"Dummy street" , "Victoria", "Tamaulipas", "87078", "8341234567", "juan@mail.com");		
		try {
			Assert.assertEquals("Please correct the errors in your checkout details", checkout.validateErrorsMainForm());
			System.out.println("TC0019 Passed: " + checkout.validateErrorsMainForm());
		} catch (Exception e) {
			System.out.println("TC0019 Failed" + e);
		}
	}
	
	@Test
	public void returningCustumerValid() {
		/* 
		 * TC0022
		 * DESCRIPTION: User types a registered email account and its respective password
		 * EXPECTED RESULT: Success
		 */			
		products.addProduct();
		products.viewCartPage();
		products.redirectCheckout();
		checkout.setReturningCostumerTrue("eder@gmail.com", "1234567");
		try {
			MatcherAssert.assertThat(checkout.validateSuccessLogin(), CoreMatchers.containsString("You are currently checking out as"));
			System.out.println("TC0022 Passed: " + checkout.validateSuccessLogin());
		} catch (Exception e) {
			System.out.println("TC0022 Ha ocurrido un error: " + e);
		}
	}
	
	@Test
	public void returningCustomerIncorrectData() {
		/* 
		 * TC0023
		 * DESCRIPTION: User logs in through this inner form
		 * EXPECTED RESULT: 
		 */			
		products.addProduct();
		products.viewCartPage();
		products.redirectCheckout();
		checkout.setReturningCostumerTrue("juanperez@gmail.com", "098765432");
		try {
			MatcherAssert.assertThat(checkout.validateFailedLogin() , CoreMatchers.containsString("The username or password you entered is incorrect"));
			System.out.println("TC0023 Passed: " + checkout.validateFailedLogin());
		} catch (Exception e) {
			System.out.println("TC0023 Ha ocurrido un error: " + e);
		}
	}
	
	@Test
	public void newAccountSuccess() {
		/* 
		 * TC0024
		 * DESCRIPTION: User logs in through this inner form
		 * EXPECTED RESULT: 
		 */			
		products.addProduct();
		products.viewCartPage();
		products.redirectCheckout();
		checkout.setCreateNewAccountTrue("Juan", "Perez", "1234567", "1234567");
		checkout.fillMainForm("Mexico", "Juan", "Perez", "Softtek" ,"Dummy street" , "Victoria", "Tamaulipas", "87078", "8341234567", "eder4@mail.com");		
		try {
			MatcherAssert.assertThat(shipping.getSuccessAccountCreation() , CoreMatchers.containsString("account has been created"));
			System.out.println("TC0028 Passed: "+ shipping.getSuccessAccountCreation());
		} catch (Exception e) {
			System.out.println("TC0028 Ha ocurrido un error");
		}
	}
	
	@Test
	public void newAccountExisting() {
		/* 
		 * TC0030
		 * FAILURE: Attempt to create an existing account
		 */
		products.addProduct();
		products.viewCartPage();
		products.redirectCheckout();
		checkout.setCreateNewAccountTrue("Juan", "Perez", "1234567", "1234567");
		checkout.fillMainForm("Mexico", "Juan", "Perez", "Softtek" ,"Dummy street" , "Victoria", "Tamaulipas", "87078", "8341234567", "eder2@mail.com");		
		try {
			MatcherAssert.assertThat(checkout.validateFailedNewAccountExisting() , CoreMatchers.containsString("This email already has an account"));
			System.out.println("TC0030 Passed");
		} catch (Exception e) {
			System.out.println("TC0030 Failed");
		}
	}	
	
	@Test
	public void newAccountMissingRequiredFields() {
		
		/* 
		 * TC0029
		 * FAILURE: Missing required fields must cause error message(s)
		 */
		
		products.addProduct();
		products.viewCartPage();
		products.redirectCheckout();
		checkout.setCreateNewAccountTrue("", "", "", "");
		checkout.fillMainForm("Mexico", "Juan", "Perez", "Softtek" ,"Dummy street" , "Victoria", "Tamaulipas", "87078", "8341234567", "eder2@mail.com");		
		try {
			Assert.assertEquals("Please correct the errors in your checkout details", checkout.validateFailedNewAccount());
			System.out.println("TC0029 Passed");
		} catch (Exception e) {
			System.out.println("TC0029 Failed");
		}
	}
	
	@Test
	public void differentAddressValid() {
		products.addProduct();
		products.viewCartPage();
		products.redirectCheckout();
		checkout.setShipDifferentAddressTrue("Mexico",  "Pedro", "Perez", "Other Dummy St.", "Dummy city", "808080", "8341109981");
		checkout.fillMainForm("Mexico", "Juan", "Perez", "Softtek" ,"Dummy street" , "Victoria", "Tamaulipas", "87078", "8341234567", "eder@mail.com");		
		try {
			Assert.assertEquals("Shipping Information", shipping.getLabel());
			System.out.println("TC0026 Passed");
		} catch (Exception e) {
			System.out.println("TC0026 Failed");
		}
	}
	
	@Test
	public void differentAddressMissingRequiredFields() {
		products.addProduct();
		products.viewCartPage();
		products.redirectCheckout();
		checkout.setShipDifferentAddressTrue("",  "Eduardo", "", "", "", "", "");
		checkout.fillMainForm("Mexico", "Juan", "Perez", "Softtek" ,"Dummy street" , "Victoria", "Tamaulipas", "87078", "8341234567", "eder@mail.com");		
		try {
			Assert.assertEquals("Please correct the errors in your checkout details", checkout.validateFailedDifferentAddress());
			System.out.println("TC0027 Passed");
		} catch (Exception e) {
			System.out.println("TC0027 Failed");
		}
	}	
  @BeforeMethod
  public void beforeMethod() {
	  	System.setProperty(TYPE_DRIVER, PATH_DRIVER);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		products = new ProductsPage(driver);
		checkout = new CheckoutPage(driver);
		shipping = new ShippingPage(driver);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
