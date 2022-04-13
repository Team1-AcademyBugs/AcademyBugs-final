package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegisterPage;
import utils.Data;
import utils.Locators;

import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class SignUpTest {
	
	
	private WebDriver driver;
	RegisterPage registerPage;
	
  @Test
  public void signUptest() {
	  String name = Data.getRandomFirstName();
	  String lastName = Data.getRandomLastName();
	  String email = Data.getRandomEmail();
	  String password = Data.getRandomPassword();
	  String succesfullSignUp = registerPage
			  .goToSignUpPage()
			  .sendDataToItem(Locators.firstNameField,name)
			  .sendDataToItem(Locators.lastNameField,lastName)
			  .sendDataToItem(Locators.emailField,email)
			  .sendDataToItem(Locators.retypeEmailField,email)
			  .sendDataToItem(Locators.passwordField,password)
			  .sendDataToItem(Locators.retypePasswordField,password)
			  .clickRegisterButton()
			  .getSuccesfulSignUp();
			  
	  assertEquals(succesfullSignUp,email);
  }
  @Test
  public void emptyEmailTest() {
	  SoftAssert softAssertion = new SoftAssert();
	  registerPage.goToSignUpPage().clickRegisterButton();
	  softAssertion.assertEquals(registerPage.getTextResponse(Locators.emptyNameField),Locators.emptyNameError);
	  softAssertion.assertEquals(registerPage.getTextResponse(Locators.emptyLastNameField),Locators.emptyLastNameError);
	  softAssertion.assertEquals(registerPage.getTextResponse(Locators.emptyEmailField),Locators.emptyEmailError);
	  softAssertion.assertEquals(registerPage.getTextResponse(Locators.emptyPasswordField),Locators.emptyPasswordError);
	  softAssertion.assertAll();
  }
  @Test
  public void differentEmailTest() {
	  String email1 = Data.getRandomEmail();
	  String email2 = Data.getRandomEmail();
	  String emailError = registerPage.goToSignUpPage()
	  .sendDataToItem(Locators.emailField,email1)
	  .sendDataToItem(Locators.retypeEmailField,email2)
	  .clickRegisterButton()
	  .getTextResponse(Locators.incorrectEmailField);
	  assertEquals(emailError,Locators.invalidEmailError);
  }
  @Test
  public void differentPasswordtest() {
	  String password1 = Data.getRandomPassword();
	  String password2 = Data.getRandomPassword();
	  String passwordError = registerPage
			  .goToSignUpPage()
			  .sendDataToItem(Locators.passwordField,password1)
			  .sendDataToItem(Locators.passwordField,password2)
			  .clickRegisterButton()
			  .getTextResponse(Locators.incorrectPasswordField);
	  assertEquals(passwordError,Locators.invalidPasswordError);
  }
  @Test
  public void existingEmailTest() {
	  String name = Data.getRandomFirstName();
	  String lastName = Data.getRandomLastName();
	  String email = Data.getRandomLoginEmail();
	  String password = Data.getRandomLoginPassword();
	  String existingAccountError = registerPage.goToSignUpPage()
			  .sendDataToItem(Locators.firstNameField,name)
			  .sendDataToItem(Locators.lastNameField,lastName)
			  .sendDataToItem(Locators.emailField,email)
			  .sendDataToItem(Locators.retypeEmailField,email)
			  .sendDataToItem(Locators.passwordField,password)
			  .sendDataToItem(Locators.retypePasswordField,password)
			  .clickRegisterButton()
			  .getTextResponse(Locators.existingAccountField);
			  
	  assertEquals(existingAccountError,Locators.existingEmailError);
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
