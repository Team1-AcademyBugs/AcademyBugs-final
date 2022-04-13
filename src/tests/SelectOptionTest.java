package tests;

import org.testng.annotations.Test;

import pages.SelectOptions;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class SelectOptionTest {
	private WebDriver driver;
	SelectOptions SelectOption;
	@Test
	void test() {
		SelectOption.SelectOption();
		
	}
  @BeforeMethod
  public void beforeMethod() {
	  SelectOption=new SelectOptions(driver);
		driver =SelectOption.chromeDriver();
		SelectOption.visit("https://academybugs.com/");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
