package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
	private WebDriver driver;
	private By btnAddCart = By.xpath("//a[@id='ec_add_to_cart_5']");
	private By viewCart = By.xpath("//a[@title='View Cart']");
	private By successMessage = By.xpath("//div[@class='ec_product_added_to_cart']/a");
    private By btnCheckout = By.xpath("//a[@class='ec_cart_button academy-checkout-bug']");

	@SuppressWarnings("deprecation")
    protected final Wait<WebDriver> wait;

	
	public ProductsPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 30);
		this.driver = driver;
	}
	
	public void addProduct() {
		driver.findElement(btnAddCart).click();
	}
	
	public String getSuccessMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));	
		return driver.findElement(successMessage).getText();
	}
	public void viewCartPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewCart));
		driver.findElement(viewCart).click();
	}
	public void redirectCheckout() {
		wait.until(ExpectedConditions.elementToBeClickable(btnCheckout));
		driver.findElement(btnCheckout).click();
	}

}
