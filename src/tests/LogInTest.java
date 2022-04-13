package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginPage;
import utils.Data;
import utils.Locators;

public class LogInTest {
	private WebDriver driver;
	LoginPage logInPage;
  @Test
  public void logInTest() {
	  String email = Data.getRandomLoginEmail();
	  String password = Data.getRandomLoginPassword();
	  String succesfullLogInMessage = logInPage
			  .goToLogInPage()
			  .sendDataToItem(Locators.loginEmailField,email)
			  .sendDataToItem(Locators.loginPasswordField,password)
			  .clickLogInButton()
			  .getTextResponse(Locators.emailLoggedIn);
	  assertEquals(succesfullLogInMessage,email);
  }
  @Test
  public void wrongPasswordTest() {
	  String email = Data.getRandomLoginEmail();
	  String password = Data.getRandomPassword();
	  String errorMessage = logInPage
			  .goToLogInPage()
			  .sendDataToItem(Locators.loginEmailField,email)
			  .sendDataToItem(Locators.loginPasswordField,password)
			  .clickLogInButton()
			  .getTextResponse(Locators.accountErrorField);
	  assertEquals(errorMessage,Locators.accountErrorMessage);
  }
  @Test
  public void emptyFieldsLogIn() {
	  SoftAssert softAssertion = new SoftAssert();
	  softAssertion.assertEquals(logInPage.goToLogInPage().clickLogInButton().getTextResponse(Locators.emptyLoginEmailField), Locators.emptyLoginEmailError);
	  softAssertion.assertEquals(logInPage.goToLogInPage().clickLogInButton().getTextResponse(Locators.emptyLoginPasswordField), Locators.emptyLoginPasswordError);
	  softAssertion.assertAll();
  }
  @Test
  public void noAccountTest() {
	  String email = Data.getRandomEmail();
	  String password = Data.getRandomLoginPassword();
	  String noAccountMessage = logInPage
			  .goToLogInPage()
			  .sendDataToItem(Locators.loginEmailField,email)
			  .sendDataToItem(Locators.loginPasswordField,password)
			  .clickLogInButton()
			  .getTextResponse(Locators.accountErrorField);
	  assertEquals(noAccountMessage,Locators.accountErrorMessage);
  }
  @BeforeMethod
  public void setUp() {
	  logInPage = new LoginPage(driver);
	  driver = logInPage.chromeDriver();
	  
  }
  @AfterMethod
  public void tearUp() {
	  driver.quit();
  }
}
