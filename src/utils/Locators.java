package utils;

import org.openqa.selenium.By;

public class Locators {
	
	public static String signUpURL ="https://academybugs.com/account/?ec_page=register";
	public static String baseURL ="https://academybugs.com/find-bugs/";
	//Register Locators
	public static By firstNameField = By.name("ec_account_register_first_name");
	public static By lastNameField = By.name("ec_account_register_last_name");
	public static By emailField = By.name("ec_account_register_email");
	public static By retypeEmailField = By.name("ec_account_register_retype_email");
	public static By passwordField = By.name("ec_account_register_password");
	public static By retypePasswordField = By.name("ec_account_register_password_retype");
	public static By registerButton = By.xpath("//input[@value='REGISTER']");
	public static By emailLoggedIn = By.xpath("//div[@id=\"ec_account_dashboard\"]/div[2]/div[3]");
	public static By emptyNameField = By.id("ec_account_register_first_name_error");
	public static By emptyLastNameField = By.id("ec_account_register_last_name_error");
	public static By emptyEmailField = By.id("ec_account_register_email_error");
	public static By emptyPasswordField = By.id("ec_account_register_password_error");
	public static By incorrectEmailField = By.id("ec_account_register_email_retype_error");
	public static By incorrectPasswordField = By.id("ec_account_register_password_retype_error");
	public static By existingAccountField = By.xpath("//div[@class='ec_account_error']/div[1]");
	//Error messages
	public static String emptyNameError = "Please enter your First Name";
	public static String emptyLastNameError = "Please enter your Last Name";
	public static String emptyEmailError = "Please enter a valid Email";
	public static String emptyPasswordError = "Please enter a password of at least 6 characters";
	public static String invalidEmailError = "Your email addresses do not match";
	public static String invalidPasswordError = "Your passwords do not match";
	public static String existingEmailError = "The email you have entered already has an account.";
	public static String accountErrorMessage = "The username or password you entered is incorrect. Forgot Your Password?";
	public static String emptyLoginEmailError ="Please enter your Email Address";
	public static String emptyLoginPasswordError = "Please enter your Password";
	public static String confirmShippingUpdated = "Your shipping information was updated successfully.";
	public static String confirmBasicUpdated = "Your personal information was updated successfully.";
	//Log In Locators
	public static By loginEmailField = By.id("ec_account_login_email");
	public static By loginPasswordField = By.id("ec_account_login_password");
	public static By loginButton = By.xpath("//input[@value='SIGN IN']");
	public static By accountErrorField = By.xpath("//div[@class='ec_account_error']/div[1]");
	public static By emptyLoginEmailField = By.id("ec_account_login_email_error");
	public static By emptyLoginPasswordField = By.id("ec_account_login_password_error");
	//Account Navigation Locators
	public static By billingInformationField = By.xpath("//div[@class='ec_account_right']/div[2]/a[1]");
	public static By shippingInformationField = By.xpath("//div[@class='ec_account_right']/div[3]/a[1]");
	public static By basicInformationField = By.xpath("//div[@class='ec_account_right']/div[4]/a[1]");
	public static By updatePasswordField = By.xpath("//div[@class='ec_account_right']/div[5]/a[1]");
	//Update billing information
	public static By selectCountryField = By.xpath("//select[@name='ec_account_billing_information_country']");
	public static By firstNameBillingField = By.name("ec_account_billing_information_first_name");
	public static By lastNameBillingField = By.name("ec_account_billing_information_last_name");
	public static By addressBillingField = By.name("ec_account_billing_information_address");
	public static By cityBillingField = By.name("ec_account_billing_information_city");
	public static By zipCodeBillingField = By.name("ec_account_billing_information_zip");
	public static By phoneBillingField = By.name("ec_account_billing_information_phone");
	public static By updateButtonBillingFIeld = By.xpath("//input[@class='ec_account_button']");
	public static By updateBillingErrorIcon = By.xpath("//span[@class='ec_cart_billing_info_update_loader academy-bug']");
	//Update shipping information
	public static By selectCountryShippingField = By.xpath("//select[@id='ec_account_shipping_information_country']");
	public static By firstNameShippingField = By.xpath("//input[@name='ec_account_shipping_information_first_name']");
	public static By lastNameShippingField = By.xpath("//input[@id='ec_account_shipping_information_last_name']");
	public static By addressShippingField = By.xpath("//input[@id='ec_account_shipping_information_address']");
	public static By cityShippingField = By.id("ec_account_shipping_information_city");
	public static By zipCodeShippingField = By.id("ec_account_shipping_information_zip");
	public static By phoneShippingField = By.id("ec_account_shipping_information_phone");
	public static By updateButtonShippingField = By.xpath("//input[@value='UPDATE']");
	public static By confirmUpdateMessage = By.xpath("//div[@class='ec_account_success']/div[1]");
	//Update basic information
	public static By firstNameBasicField = By.id("ec_account_personal_information_first_name");
	public static By lastNameBasicField = By.id("ec_account_personal_information_last_name");
	public static By emailBasicField = By.id("ec_account_personal_information_email");
	//Update password information
	public static By oldPasswordField = By.id("ec_account_password_current_password");
	public static By newPasswordField = By.id("ec_account_password_new_password");
	public static By retypePasswordBasicField = By.id("ec_account_password_retype_new_password");
	//Principal Page Locators
	public static String principalPageURL = "https://academybugs.com/store/";
	public static By productSearchField = By.name("ec_search");
	public static By productSearchBtn = By.xpath("//input[@value='Search']");
	public static By hotItemLink = By.xpath("//div[@id='ec_product_widget_item']/div[2]/a");
	public static By allItemsLink = By.id("menu3");
	public static By accessoriesLink = By.xpath("//a[@id='menu2']/span");
	public static By handPurLink = By.id("submenu1");
	public static By braceletsLink = By.id("submenu2");
	public static By fashionTypeLink = By.xpath("//a[@id='menu4']/span");
	public static By wkndLink = By.id("submenu5");
	public static By wmnsPantsLink = By.id("menu5");
	//MyCart
		public static By AddProductToCart1 = By.id("ec_add_to_cart_2");
		public static By AddProductToCart2 = By.id("ec_add_to_cart_5");

		public static By GoToMyCart = By.xpath("//a[@title='View Cart']");
		public static By RemoveFromMyCart = By.xpath("//tr[@class='ec_cartitem_row'][1]/td[1]/div");
		public static By ProductNameMyCart = By.xpath("//tr[@class='ec_cartitem_row'][1]/td[3]/a");
		public static By PriceProductMyCart = By.xpath("//tr[@class='ec_cartitem_row'][1]/td[4]");
		public static By TotalProductMyCart = By.xpath("//tr[@class='ec_cartitem_row'][1]/td[6]");
		public static By MinusMyCart = By.xpath("//tr[@class='ec_cartitem_row'][1]/td[5]/table/tbody/tr/td[1]/input");
		public static By QuantityMyCart = By.xpath("//tr[@class='ec_cartitem_row'][1]/td[5]/table/tbody/tr/td[2]/input");
		public static By UpdateMyCart = By.xpath("//tr[@class='ec_cartitem_row'][1]/td[5]/table/tbody/tr[2]/td/div");
		public static By PlusMyCart = By.xpath("//tr[@class='ec_cartitem_row'][1]/td[5]/table/tbody/tr/td[3]/input");

		public static By SubtotalMyCart = By.id("ec_cart_subtotal");
		public static By ShippingMyCart = By.id("ec_cart_shipping");
		public static By TotalMyCart = By.id("ec_cart_total");
		public static By CurrencyMyCart = By.id("ec_currency_conversion");

		public static By InputCouponMyCart = By.id("ec_coupon_code");
		public static By ButtonCouponMyCart = By.id("ec_apply_coupon");
		public static By ErrorLabelCouponMyCart = By.id("ec_coupon_error");
		public static By InputGiftCardMyCart = By.id("ec_gift_card");
		public static By ButtonGiftCardMyCart = By.id("ec_apply_gift_card");
		public static By ErrorLabelGiftCardMyCart = By.id("ec_gift_card_error");

		public static By ClosePopUpFirstMyCart = By.xpath("//div[@id='popmake-4406']/button");
		public static By ClosePopUpSecondMyCart = By.xpath("//div[@id='popmake-4393']/button");
		
		public static int valueShop=5;
		public static int valueShop2=4;
	
	
}
