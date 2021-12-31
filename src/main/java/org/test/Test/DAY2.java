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

public class DAY2 {
public static void main(String[] args) throws IOException {
	File file=new File("C:\\Users\\user\\Desktop\\book1.xlsx");
	//get a worbook
	FileInputStream str =new FileInputStream(file);
	//create a workbook
	Workbook wkbk=new XSSFWorkbook(str);
	//create a sheet
	Sheet sh = wkbk.getSheet("Sheet1");
	//get a rows count
	int rc = sh.getPhysicalNumberOfRows();
	for (int i = 0; i < rc; i++) {
		Row row = sh.getRow(i);
		
		int cellcount = row.getPhysicalNumberOfCells();
		for (int j = 0; j <cellcount; j++) {
			Cell cell = row.getCell(j);
			int type = cell.getCellType();
			String va=null;
			if(type==1) {
				 va = cell.getStringCellValue();
				
			}
			else {
				if(DateUtil.isCellDateFormatted(cell)) {
					Date da = cell.getDateCellValue();
					SimpleDateFormat si=new SimpleDateFormat("dd-MMM-yy");
					 va = si.format(da);
					
				}
				
				else {
				double d = cell.getNumericCellValue();	
				long l=(long)d;
				 va = String.valueOf(l);
				
				}
			}
			System.out.println(va);
		}
	
		
	}
	
	
	
	
	
	
}
}
