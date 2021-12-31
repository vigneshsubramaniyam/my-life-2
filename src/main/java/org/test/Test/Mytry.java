package org.test.Test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Mytry {

public static void main(String[] args) throws IOException {
File file=new File("C:\\Users\\user\\Desktop\\Book1.xlsx");
FileInputStream str =new FileInputStream(file);

// create workbook
Workbook wkbk=new XSSFWorkbook(str);

//create sheet
Sheet sh = wkbk.getSheet("sheet1");

//create row count
int rowcount = sh.getPhysicalNumberOfRows();
for (int i = 0; i < rowcount; i++) {
Row row = sh.getRow(i);	

int numberOfCells = row.getPhysicalNumberOfCells();
for (int j = 0; j < numberOfCells; j++) {
	Cell cell = row.getCell(j);
	int type = cell.getCellType();
	if (type==1) {
		String string = cell.getStringCellValue();
		System.out.println(string);
		}
	else {
		if (DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy");
			String string = sdf.format(date);
			System.out.println(string);
			
		}
		else {
			double d = cell.getNumericCellValue();
			long l =(long)d;
			String string = String.valueOf(l);
			System.out.println(string);
			
		}
	}
	
	
}
}
}
}



