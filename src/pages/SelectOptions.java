package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Base;

public class SelectOptions extends Base {
	
	public SelectOptions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//localizadores de los links que queremos probar
		By FindBugs= By.xpath("//a[contains(text(),'Find Bugs')]");
		By SelectOptions= By.xpath("(//a[contains(text(),'Select Options')])[4]");
		By boton=By.xpath("//img[@title='Small']");
		By comment= By.id("comment");
		By author= By.id("author");
		By email=By.id("email");
		By boton1=By.xpath("(//button[@type='button'])[7]");
		By url=By.id("url");
		By submit=By.id("academy-comment-submit");
		

		public void SelectOption() {
			//Thread.sleep(500);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(boton));
			espera(boton1);
			click(boton1);
			if(isDisplayed(FindBugs)) {
				click(FindBugs);
				System.out.println("Elegir productos");
				espera (SelectOptions);
				if(isDisplayed(SelectOptions)) {
					click(SelectOptions);
					System.out.println("Seleccionar el botor de select options");}
				espera (boton);
				if(isDisplayed(boton)) {
					click(boton);
					System.out.println("elegir el size");
				}
				if(isDisplayed(comment)) {
					click(comment);
					type("comment", comment);
					System.out.println("Ya se insertó el comentario");
				}
				if(isDisplayed(author)) {
					click(author);
					type("comment", author);
					System.out.println("Ya se insertó el nombre");
				}
				if(isDisplayed(email)) {
					click(email);
					type("comment@paoa.com", email);
					System.out.println("Ya se insertó el email");
				}
				if(isDisplayed(url)) {
					click(url);
					type("comment@paoa.com", url);
					System.out.println("Ya se insertó el web site");
				}
				if(isDisplayed(submit)) {
					click(submit);
					System.out.println("submit");
					System.out.println("End");
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
