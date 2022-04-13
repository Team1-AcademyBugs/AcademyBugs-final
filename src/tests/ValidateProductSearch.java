package tests;

import org.testng.annotations.Test;

import pages.PrincipalPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class ValidateProductSearch {
	private WebDriver driver;
	PrincipalPage principalPage;
	 @Test
	  public void productSearchTest() {
		  principalPage.searchProducts();
	  }
  @BeforeMethod
  public void beforeMethod() {
	  principalPage = new PrincipalPage(driver);
	  driver = principalPage.chromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
