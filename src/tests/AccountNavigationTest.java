package tests;

import org.testng.annotations.Test;

import pages.AccountNavigationPage;
import utils.Data;
import utils.Locators;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class AccountNavigationTest {
	private WebDriver driver;
	AccountNavigationPage accountNavigation;
  @Test
  public void updateBillingInformationTest() {
	  String email = Data.getRandomLoginEmail();
	  String password = Data.getRandomLoginPassword();
	  
	  boolean updated = accountNavigation
			  .logIn(email, password)
			  .clickOnElement(Locators.billingInformationField)
			  .selectElementByText(Locators.selectCountryField,Data.getRandomCountry())
			  .sendDataToItem(Locators.firstNameBillingField, Data.getRandomFirstName())
			  .sendDataToItem(Locators.lastNameBillingField, Data.getRandomLastName())
			  .sendDataToItem(Locators.addressBillingField, Data.getRandomAddress())
			  .sendDataToItem(Locators.cityBillingField, Data.getRandomCity())
			  .sendDataToItem(Locators.zipCodeBillingField, Data.getRandoZipCode())
			  .sendDataToItem(Locators.phoneBillingField, Data.getRandomPhone())
			  .clickOnElement(Locators.updateButtonBillingFIeld)
			  .errorIsVisible(Locators.updateBillingErrorIcon);
	  assertTrue(updated);
			  
  }
  @Test
  public void updateShippingInformationTest() {
	  String email = Data.getRandomLoginEmail();
	  String password = Data.getRandomLoginPassword();
	  String updateShipping = accountNavigation
			  .logIn(email, password)
			  .clickOnElement(Locators.shippingInformationField)
			  .selectElementByText(Locators.selectCountryShippingField,Data.getRandomCountry())
			  .sendDataToItem(Locators.firstNameShippingField, Data.getRandomFirstName())
			  .sendDataToItem(Locators.lastNameShippingField, Data.getRandomLastName())
			  .sendDataToItem(Locators.addressShippingField, Data.getRandomAddress())
			  .sendDataToItem(Locators.cityShippingField, Data.getRandomCity())
			  .sendDataToItem(Locators.zipCodeShippingField, Data.getRandoZipCode())
			  .sendDataToItem(Locators.phoneShippingField, Data.getRandomPhone())
			  .clickOnElement(Locators.updateButtonShippingField)
			  .getTextFromElement(Locators.confirmUpdateMessage);
	  assertEquals(updateShipping,Locators.confirmShippingUpdated);
			  
	  
  }
  @Test
  public void updateBasicInformationTest() {
	  String email = Data.getRandomLoginEmail();
	  String password = Data.getRandomLoginPassword();
	  String updateBasic = accountNavigation
			  .logIn(email, password)
			  .clickOnElement(Locators.basicInformationField)
			  .sendDataToItem(Locators.firstNameBasicField, Data.getRandomFirstName())
			  .sendDataToItem(Locators.lastNameBasicField, Data.getRandomLastName())
			  .sendDataToItem(Locators.emailBasicField, email)
			  .clickOnElement(Locators.updateButtonShippingField)
			  .getTextFromElement(Locators.confirmUpdateMessage);
	  assertEquals(updateBasic,Locators.confirmBasicUpdated);
  }
  @Test
  public void updatePasswordTest() {
	  String email = Data.getRandomLoginEmail();
	  String password = Data.getRandomLoginPassword();
	  String updateBasic = accountNavigation
			  .logIn(email, password)
			  .clickOnElement(Locators.updatePasswordField)
			  .sendDataToItem(Locators.oldPasswordField, password)
			  .sendDataToItem(Locators.newPasswordField, password)
			  .sendDataToItem(Locators.retypePasswordBasicField, password)
			  .clickOnElement(Locators.updateButtonShippingField)
			  .getTextResponse(Locators.emailLoggedIn);
	  assertEquals(updateBasic,email);
  }
  @BeforeMethod
  public void beforeMethod() {
	  accountNavigation = new AccountNavigationPage(driver);
	  driver = accountNavigation.chromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
