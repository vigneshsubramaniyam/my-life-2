package org.test.Test;

import java.io.File;
import java.io.FileInputStream;
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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Libglobal {
	public static WebDriver driver;

	public void getdriver() {
		WebDriverManager.chromedriver().version("96").setup();
		driver = new ChromeDriver();
	}

	public void loadurl(String url) {
		driver.get(url);
	}

	public WebElement findElementById(String value) {
		WebElement ele = driver.findElement(By.id(value));
		return ele;
	}


	public WebElement findElementByName(String value) {
		WebElement ele = driver.findElement(By.name(value));
		return ele;
	}
	public void insertValue(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	public void click(WebElement ele) {
		ele.click();
	}

	public void dropDownSelect(WebElement ele, String value) {
		Select s = new Select(ele);
		s.selectByVisibleText(value);
	}

	public String getAttribute(WebElement ele) {
		String txt = ele.getAttribute("value");
		return txt;
	}

	public String getData(int rownNo, int colName) throws IOException {
		String data = null;
		File f = new File("C:\\Users\\user\\Desktop\\fb sheet.xlsx");
		FileInputStream str = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(str);
		Sheet s = book.getSheet("Sheet1");
		Row r = s.getRow(rownNo);
		Cell c = r.getCell(colName);
		int type = c.getCellType();
		if (type == 1) {
			data = c.getStringCellValue();
		} else {
			if (DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd-MMM-yy");
				data = sim.format(d);
			} else {
				double d = c.getNumericCellValue();
				long l = (long) d;
				data = String.valueOf(l);
			}
		}
		return data;
	}
}
