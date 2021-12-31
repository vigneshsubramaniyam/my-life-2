package org.test.Test;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Framework {
public static void main(String[] args) {
	//launch the driver
	WebDriverManager.chromedriver().version("96").setup();
	WebDriver driver=new ChromeDriver();
	driver.get("http://demo.automationtesting.in/Register.html");
	
	//find the locator of text
	WebElement element = driver.findElement(By.id("Skills"));
	
	//select object for "skills"
	Select sec=new Select( element);
	
	//fetch all options
	List<WebElement> op = sec.getOptions();
	//create list of string to store value
	List<String> li=new ArrayList<String>();
	
	
	for ( WebElement x : op) {
		
		
		//get text from webelement
		
		String text = x.getText();
		
	}
	
	
	
}
}
