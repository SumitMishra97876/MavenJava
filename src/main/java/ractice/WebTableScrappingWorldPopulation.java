package ractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableScrappingWorldPopulation {
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static FileOutputStream fos;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static void main(String[] args) throws IOException {
WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		
		driver.get("https://www.worldometers.info/world-population/#:~:text=7.96%20Billion%20(2022),Nations%20estimates%20elaborated%20by%20Worldometer.");
		
		String index=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/thead/tr/th[1]")).getText();
		String region=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/thead/tr/th[2]")).getText();
		String population=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/thead/tr/th[3]")).getText();
		String yearlyChange=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/thead/tr/th[4]")).getText();
		String netChange=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/thead/tr/th[5]")).getText();
		String density=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/thead/tr/th[6]")).getText();
		String landArea=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/thead/tr/th[7]")).getText();
		String migrants=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/thead/tr/th[8]")).getText();
		String fertRate=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/thead/tr/th[9]")).getText();
		String medAge=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/thead/tr/th[10]")).getText();
		String urbanPop=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/thead/tr/th[11]")).getText();
		String worldShare=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/thead/tr/th[12]")).getText();
		
		String filepath="D:\\Sumit\\WebTableScrappingPopulation.xlsx";
		
		setDataInExcel(filepath,"Data",0,0,index);
		setDataInExcel(filepath,"Data",0,1,region);
		setDataInExcel(filepath,"Data",0,2,population);
		setDataInExcel(filepath,"Data",0,3,yearlyChange);
		setDataInExcel(filepath,"Data",0,4,netChange);
		setDataInExcel(filepath,"Data",0,5,density);
		setDataInExcel(filepath,"Data",0,6,landArea);
		setDataInExcel(filepath,"Data",0,7,migrants);
		setDataInExcel(filepath,"Data",0,8,fertRate);
		setDataInExcel(filepath,"Data",0,9,medAge);
		setDataInExcel(filepath,"Data",0,10,urbanPop);
		setDataInExcel(filepath,"Data",0,11,worldShare);
		
		
		
		int rows=driver.findElements(By.xpath("//table[@class='table table-hover table-condensed']/tbody/tr")).size();
		
		for(int r=1;r<rows;r++)
		{
			String index1=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/tbody/tr["+r+"]/td[1]")).getText();
			String region1=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/tbody/tr["+r+"]/td[2]/a")).getText();
			String population1=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/tbody/tr["+r+"]/td[3]")).getText();
			String yearlyChange1=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/tbody/tr["+r+"]/td[4]")).getText();
			String netChange1=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/tbody/tr["+r+"]/td[5]")).getText();
			String density1=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/tbody/tr["+r+"]/td[6]")).getText();
			String landArea1=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/tbody/tr["+r+"]/td[7]")).getText();
			String migrants1=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/tbody/tr["+r+"]/td[8]")).getText();
			String fertRate1=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/tbody/tr["+r+"]/td[9]")).getText();
			String medAge1=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/tbody/tr["+r+"]/td[10]")).getText();
			String urbanPop1=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/tbody/tr["+r+"]/td[11]")).getText();
			String worldShare1=driver.findElement(By.xpath("//table[@class='table table-hover table-condensed']/tbody/tr["+r+"]/td[12]")).getText();
			
			System.out.println(index1);
			System.out.println(region1);
			System.out.println(population1);
			System.out.println(yearlyChange1);
			System.out.println(netChange1);
			System.out.println(density1);
			System.out.println(landArea1);
			System.out.println(migrants1);
			System.out.println(fertRate1);
			System.out.println(medAge1);
			System.out.println(urbanPop1);
			System.out.println(worldShare1);
			
			
			
			setDataInExcel(filepath,"Data",r,1,index1);
			setDataInExcel(filepath,"Data",r,2,index1);
			setDataInExcel(filepath,"Data",r,3,index1);
			setDataInExcel(filepath,"Data",r,4,index1);
			setDataInExcel(filepath,"Data",r,5,index1);
			setDataInExcel(filepath,"Data",r,6,index1);
			setDataInExcel(filepath,"Data",r,7,index1);
			setDataInExcel(filepath,"Data",r,8,index1);
			setDataInExcel(filepath,"Data",r,9,index1);
			setDataInExcel(filepath,"Data",r,10,index1);
			setDataInExcel(filepath,"Data",r,11,index1);
			setDataInExcel(filepath,"Data",r,12,index1);
			
			
			
		}
		
		
		
		System.out.println("Writing Successful");
		
	}
	
	
	public static void setDataInExcel(String filepath,String sheetname,int rows,int col,String data) throws IOException
	{
		fis=new FileInputStream(filepath);
		workbook=new XSSFWorkbook(fis);
		if(workbook.getSheetIndex(sheetname)==-1)
			workbook.createSheet(sheetname);
		
		sheet=workbook.getSheet(sheetname);
		
		if(sheet.getRow(rows)==null)
			sheet.createRow(rows);
		
		row=sheet.getRow(rows);
		
		cell=row.createCell(col);
		cell.setCellValue(data);
		
		fos=new FileOutputStream(filepath);
		
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
		
		
	}
	
	
	
	

}
