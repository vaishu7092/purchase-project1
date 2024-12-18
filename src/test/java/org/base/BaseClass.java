package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static WebDriver browserLaunch(String bname)
	{
		switch(bname) {
		
		case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			default:
				throw new WebDriverException();
		}
				return driver;
		
		}
	
	public static void urlLaunch(String url)	{
		driver.get(url);
		driver.manage().window().maximize();
	}
    
	public static void implicitlyWait(int a) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(a));
	}
	
     public static void sendKeys(WebElement e,String a) {
    	 e.sendKeys(a);
     }
     public static void click(WebElement e)
     {
    	 e.click();
     }
     
     public static String getCurrentUrl() {
    	 String url=driver.getCurrentUrl();
    	 return url;
     }
     public static String getTitle() {
    	 String title=driver.getTitle();
    	 return title;
     }
     public static String getText(WebElement e) {
    String text=e.getText(); 
    return text;
     }
     
     public static String getAttribute(WebElement e) {
    	String attribute=e.getAttribute("value");
    	return attribute;
     }
     public static void moveToElement(WebElement tar) {
    	 Actions a=new Actions(driver);
    	 a.moveToElement(tar).perform();
     }
     public static void dragAndDrop(WebElement src,WebElement tar) {
    	 Actions a=new Actions(driver);
    	 a.dragAndDrop(src, tar).perform();
     }
     public static void selectByValue(WebElement e,String value) {
    	 Select s=new Select(e);
    	 s.selectByValue(value);
     }
     public static void deSelectByVisibleText(WebElement e,String Text) {
    	 Select s=new Select(e);
    	 s.deselectByVisibleText(Text);
     }
     public static void refresh() {
    	 driver.navigate().refresh();
     }
     public static void quit()
{
	driver.quit();
}

     public static String excelReadData(String fname,String sheet,int row,int cell) throws IOException  {
    	 File f=new File("D:\\eclipse\\MavenProject1.1\\src\\test\\resources\\TestData\\"+fname+".xlsx");
    	 FileInputStream sf=new FileInputStream(f);
    	 Workbook w=new XSSFWorkbook(sf);
    	 Sheet s=w.getSheet(sheet);
    	 Row r=s.getRow(row);
    	 Cell cell1 = r.getCell(cell);
    	 int type= cell1.getCellType();
    	 String value=null;
    	 if(type==1) {
    		 value= cell1.getStringCellValue();
    		 
    	 }
    	 else {
    		 if(DateUtil.isCellDateFormatted(cell1)) {
    			Date dateCellValue= cell1.getDateCellValue();
    			SimpleDateFormat sd=new SimpleDateFormat("dd-MMM-yyyy");
    			value=sd.format(dateCellValue);
    			
    			 }
    		 else {
    			 double numericCellValue= cell1.getNumericCellValue();
    			 long num=(long)numericCellValue;
    			 value=String.valueOf(num);
    		 }
    	 
    	 }
    	 return value;
    	 
     }
}

