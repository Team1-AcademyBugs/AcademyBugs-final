package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Base;

public class Top_Navigation_Menu_Design extends Base{
	
	//localizadores de los links que queremos probar
	By AcademyBugs = By.xpath("//a[contains(text(),'AcademyBugs.com')]");
	By ExamplesBugs= By.xpath("//a[contains(text(),'Examples of Bugs')]");
	By TypesBugs= By.xpath("//a[contains(text(),'Types of Bugs')]");
	By FindBugs= By.xpath("//a[contains(text(),'Find Bugs')]");
	By ReportBugs= By.xpath("//a[contains(text(),'Report Bugs')]");
	By boton=By.xpath("(//button[@type='button'])[7]");
	By TermsConditions= By.xpath("//a[contains(text(),'Terms & Conditions')]");
	By PrivacyPolicy= By.xpath("//a[contains(text(),'Privacy Policy')]");
	By bugs=By.xpath("/html/body/div[3]/footer/div/div[1]/div/div/div/ul/li[1]/a/img");

	public Top_Navigation_Menu_Design(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void TopLinks() {
		//Thread.sleep(500);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(boton));
		espera(boton);
		if(isDisplayed(boton)) {
			click(boton);
			System.out.println("Cerré la ventana del tutorial para proceder");
			if(isDisplayed(ExamplesBugs)) {
				click(ExamplesBugs);
				System.out.println("Entré al link de ejemplos de bugs");}
			if(isDisplayed(TypesBugs)) {
				click(TypesBugs);
				System.out.println("Entré al link de tipos de bugs");
			}
			if(isDisplayed(FindBugs)) {
				click(FindBugs);
				System.out.println("Entré al link de find bugs");
			}
			if(isDisplayed(ReportBugs)) {
				click(ReportBugs);
				System.out.println("Entré al link de reportar bugs");
				System.out.println("Ya están probados los top menu links");
			}
			
			
			
		}
		else {
			System.out.println("Oops i could not go through the links sorry");
		}
	}
	
	public String TopLinksMessage() {
		return null;
	}
	

}