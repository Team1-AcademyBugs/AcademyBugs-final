package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage {
	
	WebDriver driver;	
	private By label = By.xpath("//div[@class='ec_cart_input_row']//label[contains(text(), 'Shipping Information')]");
	private By successDiv = By.xpath("//div[@class='ec_cart_success']//div[contains(text(), 'account has been created')]");
	
	@SuppressWarnings("deprecation")
    protected final Wait<WebDriver> wait;
    
    public ShippingPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 30);
    	this.driver = driver;
    }
    
    public String getLabel() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(label));	
		return driver.findElement(label).getText();    
	}
    public String getSuccessAccountCreation() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(successDiv));	
		return driver.findElement(successDiv).getText();  
    }

}
