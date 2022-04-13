package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Base;
import utils.Locators;
public class RegisterPage extends Base{
	public RegisterPage(WebDriver driver) {
		super(driver);
		
	}
	public RegisterPage goToSignUpPage(){
		openSite(Locators.signUpURL);
		return this;
	}
	public RegisterPage sendDataToItem(By path,String text) {
		sendText(path,text);
		return this;
	}
	public RegisterPage clickRegisterButton() {
		clickElement(Locators.registerButton);
		return this;
	}
	public String getSuccesfulSignUp() {
		return getSetText(Locators.emailLoggedIn);
	}
	public String getTextResponse(By path) {
		return getSetText(path);
	}
}
