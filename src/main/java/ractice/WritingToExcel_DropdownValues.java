package ractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WritingToExcel_DropdownValues {
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static FileOutputStream fos;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.timeanddate.com/weather/?sort=1&low=c");
		
		String filepath="D:\\Sumit\\ValuesFromSiteThroughSelenium.xlsx";
		
		
		
		
		List<WebElement> lists=driver.findElements(By.xpath("//div[@class='tb-scroll']/table//tr"));
		int rows=lists.size();
		
		
		for(int r=1;r<=rows;r++)
		{
			String capitals=driver.findElement(By.xpath("//div[@class='tb-scroll']/table//tr["+r+"]/td[1]")).getText();
			String time=driver.findElement(By.xpath("//div[@class='tb-scroll']/table//tr["+r+"]/td[2]")).getText();
			
			String temperature=driver.findElement(By.xpath("//div[@class='tb-scroll']/table//tr["+r+"]/td[4]")).getText();
			
			
			setValuesinExcel(filepath,"Test",r,1,capitals);
			setValuesinExcel(filepath,"Test",r,2,time);
			setValuesinExcel(filepath,"Test",r,3,temperature);
			
			
			
			
		}
	
		
		
		
		
		
	}
		
		
        public static void setValuesinExcel(String filepath,String sheat,int row1,int column,String data) throws IOException
        {
        	
        	fis=new FileInputStream(filepath);
        	
        	workbook=new XSSFWorkbook(fis);
        	if(workbook.getSheetIndex(sheat)==-1)
        		workbook.createSheet(sheat);
        	
        	sheet=workbook.getSheet(sheat);
        	
        	if(sheet.getRow(row1)==null)
        		sheet.createRow(row1);
        	row=sheet.getRow(row1);
        	cell=row.createCell(column);
        	
        	cell.setCellValue(data);
        	fos=new FileOutputStream(filepath);
        	workbook.write(fos);
        	workbook.close();
        	fis.close();
        	fos.close();
        	
        	
        	
        }
        
		
	
	

	}


