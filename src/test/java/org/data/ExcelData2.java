package org.data;

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



public class ExcelData2 {
	
	public static void main(String[] args) throws IOException {
		
		//1.file location
		File f=new File("D:\\eclipse\\MavenProject1.1\\src\\test\\resources\\TestData\\Datass.xlsx");
		
		//2.FileInputStream
		
		FileInputStream sf=new FileInputStream(f);
		
		//3.WorkBook
		Workbook w=new XSSFWorkbook(sf);
		
		//4.get Sheet
		
		Sheet s=w.getSheet("Sheet1");
		
		//5.getRow
		
		Row r=s.getRow(1);
		
		//6.get Cell
		
		 Cell cell = r.getCell(0);
		System.out.println(cell);
		
		int type= cell.getCellType();
		System.out.println(type);
		
		//type 1-->String
		//type 0--->Number,Date
		
		if(type==1) {
			String value=cell.getStringCellValue();
			System.out.println("value");
			
		}
	
		else {
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue= cell.getDateCellValue();
				SimpleDateFormat sd=new SimpleDateFormat("dd-MMM-YYYY");
				String value=sd.format(dateCellValue);
				System.out.println(value);
			}
			else {
				double numericCellValue= cell.getNumericCellValue();
				long num=(long)numericCellValue;
				String value=String.valueOf(num);
				System.out.println(value);
			}
		
		}
		
			
		}
	
	
	}
	


