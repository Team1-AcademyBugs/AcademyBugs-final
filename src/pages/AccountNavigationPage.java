package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Locators;

public class AccountNavigationPage extends LoginPage{

	public AccountNavigationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public AccountNavigationPage logIn(String email, String password) {
		goToLogInPage().sendDataToItem(Locators.loginEmailField,email).sendDataToItem(Locators.loginPasswordField,password).clickLogInButton();
		return this;
	}
	public AccountNavigationPage selectElementByText(By path,String text) {
		selectItem(path,text);
		return this;
	}
	public AccountNavigationPage sendDataToItem(By path,String text) {
		clearElement(path);
		sendText(path,text);
		return this;
	}
	public AccountNavigationPage clickOnElement(By path) {
		clickElement(path);
		return this;
	}
	public boolean errorIsVisible(By path) {
		return elementIsVisible(path);
	}
	public String getTextFromElement(By path) {
		return getSetText(path);
	}
}
