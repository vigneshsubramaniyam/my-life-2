package org.test.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sample2 {
public static void main(String[] args) throws IOException {
File file =new File("C:\\Users\\user\\Desktop\\book1.xlsx");
 
//create the objects  byte from the file 
FileInputStream stream=new FileInputStream(file);

//create workbook
Workbook wbk=new XSSFWorkbook(stream);

//Get sheet
Sheet sh = wbk.getSheet("Sheet1");

//rows count

int nor = sh.getPhysicalNumberOfRows();
for (int i = 0; i < nor; i++) {
	Row ro = sh.getRow(i);
	
	//cell count
	int cells = ro.getPhysicalNumberOfCells();
	for (int j = 0; j < cells; j++) {
		Cell ce = ro.getCell(j);
		System.out.println(ce);
		
	}
	
	
	
}

}
}
