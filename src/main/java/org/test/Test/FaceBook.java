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

public class FaceBook {
public static void main(String[] args) throws IOException {
	
File file=new File("C:\\Users\\user\\Desktop\\fb sheet.xlsx");

FileInputStream str=new FileInputStream(file);


Workbook wbk=new XSSFWorkbook(str);

Sheet st = wbk.getSheet("Sheet1");

// get row count
int nor = st.getPhysicalNumberOfRows();
for (int i = 0; i < nor; i++) {
	Row ro = st.getRow(i);
	
	//get cell count
	int cells = ro.getPhysicalNumberOfCells();
	for (int j = 0; j < cells; j++) {
		Cell c = ro.getCell(j);
		System.out.println(c);
	}
	
	
	
}




}
}
