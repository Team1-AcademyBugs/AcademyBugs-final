package pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	WebDriver driver;
	private By checkboxRetCostumer = By.xpath("//input[@id='ec_login_selector']");
	private By inputLoginEmail = By.xpath("//input[@id='ec_cart_login_email']");
	private By inputLoginPassword = By.xpath("//input[@id='ec_cart_login_password']");
	private By btnLogin = By.xpath("//input[@value='SIGN IN' and @type='submit']");
	private By selectCountry = By.xpath("//select[@id='ec_cart_billing_country']");
    private By inputFirstName = By.xpath("//input[@id='ec_cart_billing_first_name']");
    private By inputLastName = By.xpath("//input[@id='ec_cart_billing_last_name']");
    private By inputCompany = By.xpath("//input[@id='ec_cart_billing_company_name']");
    private By inputAddress = By.xpath("//input[@id='ec_cart_billing_address']");
    private By inputCity = By.xpath("//input[@id='ec_cart_billing_city']");
    private By inputState = By.xpath("//input[@id='ec_cart_billing_state']");
    private By inputZip = By.xpath("//input[@id='ec_cart_billing_zip']");
    private By inputPhone = By.xpath("//input[@id='ec_cart_billing_phone']");
    private By inputEmail = By.xpath("//input[@id='ec_contact_email']");
    private By inputRetypeEmail = By.xpath("//input[@id='ec_contact_email_retype']");
    private By checkboxCreateAccount = By.xpath("//input[@id='ec_create_account_selector']");
    private By inputNewAccFirstName = By.xpath("//input[@id='ec_contact_first_name']");
    private By inputNewAccLastName = By.xpath("//input[@id='ec_contact_last_name']");
    private By inputNewAccPassword = By.xpath("//input[@id='ec_contact_password']");
    private By inputNewAccRetypePassword = By.xpath("//input[@id='ec_contact_password_retype']");
    
    
    
	private By errorNewAccFirstName = By.xpath("//div[@id='ec_contact_first_name_error']");
	private By errorNewAccLastName = By.xpath("//div[@id='ec_contact_last_name_error']");
	private By errorNewAccPassword = By.xpath("//div[@id='ec_contact_password_error']");
    
    
    private By errorNewAcc = By.xpath("//div[@class='ec_cart_error']//div[contains(text(), 'This email already has an account')]");
    private By btnSubmit = By.xpath("//input[@class='ec_cart_button' and @value='CONTINUE TO SHIPPING']");  
    private By errorLogin = By.xpath("//div[@class='ec_cart_error']/div[contains(text(), 'The username or password you entered is incorrect.')]");
    private By errorLoginEmail = By.xpath("//div[@id='ec_cart_login_email_error']");
    private By errorLoginPassword = By.xpath("//div[@id='ec_cart_login_password_error']");
    private By successLogin = By.xpath("//div[@class='ec_cart_input_row' and contains(text(), 'You are currently checking out as')]");
    private By errorCountry = By.xpath("//div[@id='ec_cart_billing_country_error']");
    private By errorFirstName = By.xpath("//div[@id='ec_cart_billing_first_name_error']");
    private By errorLastName = By.xpath("//div[@id='ec_cart_billing_last_name_error']");
    private By errorAddresss = By.xpath("//div[@id='ec_cart_billing_address_error']");
    private By errorCity = By.xpath("//div[@id='ec_cart_billing_city_error']");
    private By errorPhone = By.xpath("//div[@id='ec_cart_billing_phone_error']");
    private By errorEmail = By.xpath("//div[@id='ec_contact_email_error']");
    private By errorForm = By.xpath("//div[@id='ec_checkout2_error']"); 
    
    
   private By checkboxSDAddress = By.xpath("//input[@id='ec_shipping_selector']");
   private By selectSDACountry = By.xpath("//select[@id='ec_cart_shipping_country']");
   private By inputSDAFirstName = By.xpath("//input[@id='ec_cart_shipping_first_name']");
   private By inputSDALastName = By.xpath("//input[@id='ec_cart_shipping_last_name']");
   private By inputSDAAddress = By.xpath("//input[@id='ec_cart_shipping_address']");
   private By inputSDACity = By.xpath("//input[@id='ec_cart_shipping_city']");
   private By inputSDAZip = By.xpath("//input[@id='ec_cart_shipping_zip']");
   private By inputSDAPhone = By.xpath("//input[@id='ec_cart_shipping_phone']");
   // errors
   private By errorSDACountry = By.xpath("//div[@id='ec_cart_shipping_country_error']");
   private By errorSDAFristName = By.xpath("//div[@id='ec_cart_shipping_first_name_error']");
   private By errorSDALastName = By.xpath("//div[@id='ec_cart_shipping_last_name_error']");
   private By errorSDAAddress = By.xpath("//div[@id='ec_cart_shipping_address_error']");
   private By errorSDACity = By.xpath("//div[@id='ec_cart_shipping_city_error']");
   private By errorSDAZip = By.xpath("//div[@id='ec_cart_shipping_zip_error']");
   private By errorSDAPhone = By.xpath("//div[@id='ec_cart_shipping_phone_error']");
    
    
	@SuppressWarnings("deprecation")
    protected final Wait<WebDriver> wait;
    
    @SuppressWarnings("deprecation")
	public CheckoutPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 5);
    	this.driver = driver;
    }
    
    public void fillMainForm(
    		String country,
    		String firstname, 
    		String lastname,
    		String company,
    		String address,
    		String city,
    		String state,
    		String zip,
    		String phone,
    		String email
    		) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectCountry));
    	driver.findElement(selectCountry).click();
    	CheckoutPage.selectElement(this.driver, selectCountry, country);
    	driver.findElement(inputFirstName).sendKeys(firstname);
    	driver.findElement(inputLastName).sendKeys(lastname);
    	driver.findElement(inputCompany).sendKeys(company);
    	driver.findElement(inputAddress).sendKeys(address);
    	driver.findElement(inputCity).sendKeys(city);
    	driver.findElement(inputState).sendKeys(state);
    	driver.findElement(inputZip).sendKeys(zip);
    	driver.findElement(inputPhone).sendKeys(phone);
    	driver.findElement(inputEmail).sendKeys(email);
    	driver.findElement(inputRetypeEmail).sendKeys(email);
		wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
    	driver.findElement(btnSubmit).click();    	
    }

    public String validateErrorsMainForm() {
    	List<By> errors = Arrays.asList(
        		errorCountry, 
        		errorFirstName,
        		errorLastName, 
        		errorAddresss,
        		errorCity,
        		errorPhone,
        		errorEmail,
        		errorForm
        		);    	
        errors.forEach(err -> {
        	try {
        		wait.until(ExpectedConditions.visibilityOfElementLocated(err));
        		System.out.println("Error esperado: " + driver.findElement(err).getText());

			} catch (Exception e) {
				System.out.println("Sin error en input "+ err);
			}
        });    	
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorForm));
    	return driver.findElement(errorForm).getText();
    }
    public void setReturningCostumerTrue(String email, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxRetCostumer));
		driver.findElement(checkboxRetCostumer).click();
		driver.findElement(inputLoginEmail).sendKeys(email);
		driver.findElement(inputLoginPassword).sendKeys(password);
		driver.findElement(btnLogin).click();
        	
		}
    public String validateSuccessLogin() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(successLogin));
		System.out.println("Login exitoso: " + driver.findElement(successLogin).getText());
    	return driver.findElement(successLogin).getText();   	
    }
    public String validateFailedLogin() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorLogin));
		System.out.println("Error esperado: " + driver.findElement(errorLogin).getText());
		return driver.findElement(errorLogin).getText();  
    }   
    public void setCreateNewAccountTrue(String firstname, String lastname, String password, String retypePassword) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxCreateAccount));
		driver.findElement(checkboxCreateAccount).click();
		driver.findElement(inputNewAccFirstName).sendKeys(firstname);
		driver.findElement(inputNewAccLastName).sendKeys(lastname);
		driver.findElement(inputNewAccPassword).sendKeys(password);
		driver.findElement(inputNewAccRetypePassword).sendKeys(retypePassword);
    }
    public String validateFailedNewAccount() {  
    	//validacion de campos
    	List<By> errors = Arrays.asList(
    			errorNewAccFirstName, 
    			errorNewAccLastName,
    			errorNewAccPassword,
    			errorForm
        		);    	
        errors.forEach(err -> {
        	try {
        		wait.until(ExpectedConditions.visibilityOfElementLocated(err));
        		System.out.println("Error esperado: " + driver.findElement(err).getText());

			} catch (Exception e) {
				System.out.println("Sin error en input "+ err);
			}
        });    	
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorForm));
		System.out.println(driver.findElement(errorForm).getText());
    	return driver.findElement(errorForm).getText();
    }
    public String validateFailedNewAccountExisting() {
    	//Cuenta existente
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorNewAcc));	
		return driver.findElement(errorNewAcc).getText();  
    }
    public void setShipDifferentAddressTrue(
    		String country,
    		String firstname, 
    		String lastname,
    		String address,
    		String city,
    		String zip,
    		String phone
    		) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxSDAddress));
		driver.findElement(checkboxSDAddress).click();
		if (isNotNullOrEmpty(country)) {
			driver.findElement(selectSDACountry).click();
			CheckoutPage.selectElement(this.driver, selectSDACountry, country);
		}
    	driver.findElement(inputSDAFirstName).sendKeys(firstname);
    	driver.findElement(inputSDALastName).sendKeys(lastname);
    	driver.findElement(inputSDAAddress).sendKeys(address);
    	driver.findElement(inputSDACity).sendKeys(city);
    	driver.findElement(inputSDAZip).sendKeys(zip);
    	driver.findElement(inputSDAPhone).sendKeys(phone);		
    }
    public String validateFailedDifferentAddress() {  
    	//validacion de campos
    	List<By> errors = Arrays.asList(
    			errorSDACountry,
    			errorSDAFristName,
    			errorSDALastName,
    			errorSDAAddress,
    			errorSDACity,
    			errorSDAZip,
    			errorSDAPhone,
    			errorForm
        		);    	
        errors.forEach(err -> {
        	try {
        		wait.until(ExpectedConditions.visibilityOfElementLocated(err));
        		System.out.println("Error esperado: " + driver.findElement(err).getText());

			} catch (Exception e) {
				System.out.println("Sin error en input "+ err);
			}
        });    	
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorForm));
		System.out.println(driver.findElement(errorForm).getText());
    	return driver.findElement(errorForm).getText();
    }    
	public static void selectElement(WebDriver driver, By selectCountry, String value ) {
		Select select = new Select (driver.findElement(selectCountry));
		select.selectByVisibleText(value);
	}
	private static boolean isNotNullOrEmpty(String str){
		return (str != null && !str.isEmpty());
	}
    
}
