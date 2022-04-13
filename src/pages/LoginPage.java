package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Base;
import utils.Locators;

public class LoginPage extends Base{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public LoginPage goToLogInPage(){
		openSite(Locators.signUpURL);
		return this;
	}
	public LoginPage sendDataToItem(By path,String text) {
		sendText(path,text);
		return this;
	}
	public LoginPage clickLogInButton() {
		clickElement(Locators.loginButton);
		return this;
	}
	public String getTextResponse(By path) {
		return getSetText(path);
	}


}
