package org.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
	public static void main(String[] args) throws IOException {
		// File Location
		File f=new File("D:\\eclipse\\MavenProject1.1\\src\\test\\resources\\TestData\\Datass.xlsx");
		//FileInputstream
		FileInputStream sf=new FileInputStream(f);
		//Workbook
		Workbook w=new XSSFWorkbook(sf);
		//get Sheet
		Sheet s=w.getSheet("Sheet1");
		//getRow
		Row r=s.getRow(1);
		
		//get cell
		Cell cell = r.getCell(2);
		System.out.println(cell);
		
		//to string 
		
		String s1 = cell.toString();
		System.out.println(s1);
		
		//get number of rows
		int numberOfRows = s.getPhysicalNumberOfRows();
		System.out.println(numberOfRows);
		
		//get number of cells
		int numberOfCells = r.getPhysicalNumberOfCells();
         System.out.println(numberOfCells);
         
         for(int i=0;i<s.getPhysicalNumberOfRows();i++) {
        	 Row rows=s.getRow(i);
        	 for( int j=0;j<rows.getPhysicalNumberOfCells();j++) {
        		 Cell cell2 = rows.getCell(j);
        		 System.out.println(cell2);
        	 }
         }
	}
	

}
