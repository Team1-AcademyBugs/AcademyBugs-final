package tests;

import org.testng.annotations.Test;

import pages.Top_Navigation_Menu_Design;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TopLinksMenuTest {
	private WebDriver driver;
	Top_Navigation_Menu_Design TopLinks;
	@Test
	void test() {
		TopLinks.TopLinks();
		
	}
  @BeforeMethod
  public void beforeMethod() {
	  TopLinks=new Top_Navigation_Menu_Design(driver);
		driver =TopLinks.chromeDriver();
		TopLinks.visit("https://academybugs.com/");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
