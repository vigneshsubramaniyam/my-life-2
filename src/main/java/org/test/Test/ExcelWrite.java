package org.test.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelWrite {

	public static void main(String[] args) throws IOException {
		// configure browser
		WebDriverManager.chromedriver().version("96").setup();
		WebDriver driver = new ChromeDriver();
		// lanuch url
		driver.get("http://demo.automationtesting.in/Register.html");
		// inspect skill Drop down box
		WebElement skil = driver.findElement(By.id("Skills"));
		// Create Object for select class
		Select s = new Select(skil);
		// Fetch all options
		List<WebElement> op = s.getOptions();
		// Create list of string to store value
		List<String> li = new ArrayList<String>();
		// add one by one option in list of String
		for (WebElement x : op) {
			// fetch text from webelement
			String text = x.getText();
			// add value in list
			li.add(text);
		}
		System.out.println(li);
		// Create a file path for excel
		File f = new File("C:\\Users\\user\\Desktop\\Book2.xlsx");
		// create workbbok
		Workbook wkbk = new XSSFWorkbook();
		// create sheet
		Sheet sh = wkbk.createSheet("skill");
		//create a row 
		for (int i = 0; i < li.size(); i++) {
			Row row = sh.createRow(i);
			//create cell
			Cell cell = row.createCell(0);//0 -->indicate first cell
		//set value in cell
			cell.setCellValue(li.get(i));//li.get()==>indicate text in list
		}
		
		FileOutputStream str=new FileOutputStream(f);
		
		//write in workbook
		wkbk.write(str);
	
		System.out.println("done");
	}
}
