package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	protected WebDriver driver;
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	public WebDriver chromeDriver() {
	 driver = new ChromeDriver();
	 return driver;
	}
	public void openSite(String site) {
		this.driver.get(site);
	}
	public void sendText(By path,String text) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(path));
		element.sendKeys(text);
	}
	public void clickElement(By path) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(path));
		element.click();
	}
	public String getSetText(By path) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(path));
		return element.getText();
	}
	public void selectItem(By xpath,String text) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		Select element = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(xpath)));
		element.selectByVisibleText(text);
	}
	public boolean elementIsVisible(By xpath) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
		return element.isDisplayed();
	}
	public void clearElement(By xpath) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
		element.clear();
	}
	public WebElement findElement (By locator) {
		return driver.findElement(locator);
	}
	public List<WebElement> findElements (By locator){
		return driver.findElements(locator);
	}
	public String getText(WebElement element) {
		return element.getText();
	}
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	public void click (By locator) {
		
		driver.findElement(locator).click();
	}
	public void espera (By locator) {
		WebDriverWait wait=new WebDriverWait(driver, 100);
		WebElement driver = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void select(String inputText, By locator) {
		Select select=new Select(driver.findElement(locator));
		select.selectByVisibleText(inputText);
	}
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	public void visit(String url) {
		driver.get(url);
	}
	
}
