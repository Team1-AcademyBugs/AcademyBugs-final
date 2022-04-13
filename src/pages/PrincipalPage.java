package pages;

import org.openqa.selenium.WebDriver;

import utils.Base;
import utils.Locators;

public class PrincipalPage extends Base{

	public PrincipalPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void searchProducts() {
		openSite(Locators.principalPageURL);
		sendText(Locators.productSearchField,"blue");
		clickElement(Locators.productSearchBtn);
		
	}
	public void hotItemView() {
		openSite(Locators.principalPageURL);
		clickElement(Locators.hotItemLink);
	}
	public void storeMenu() {
		openSite(Locators.principalPageURL);
		clickElement(Locators.allItemsLink);
	}

}
