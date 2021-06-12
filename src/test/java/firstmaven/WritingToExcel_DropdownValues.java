package firstmaven;

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

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
		
		List<WebElement> lists=driver.findElements(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']//option"));
		int size=lists.size();
		
		ArrayList<String> values=new ArrayList<String>();
		
		for(int i=0;i<size;i++)
		{
			String text=lists.get(i).getText();
			
		
			
			values.add(text);
		}
		//Object[] data=values.toArray();
		
		System.out.println(values.size());
		
        XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("Dropdown Info");
		
		ArrayList<Object[]> choices=new ArrayList<Object[]>();
		
		choices.add(new Object[] {values.get(0)});
		choices.add(new Object[] {values.get(1)});
		choices.add(new Object[] {values.get(2)});
		choices.add(new Object[] {values.get(3)});
		choices.add(new Object[] {values.get(4)});
		choices.add(new Object[] {values.get(5)});
		
		int rowcount=0;
		
		for(Object val[]:choices)
		{
			XSSFRow row=sheet.createRow(rowcount++);
		
		int colcount=0;
		for(Object ch:val)
		{
			//create cells
			
			XSSFCell cell=row.createCell(colcount++);
			if(ch instanceof String)
				cell.setCellValue((String)ch);
			if(ch instanceof Integer)
				cell.setCellValue((Integer)ch);
			if(ch instanceof Boolean)
				cell.setCellValue((Boolean)ch);		
			
}
}
       String filepath="D:\\Sumit\\dropdown.xlsx";
		
		FileOutputStream fos=new FileOutputStream(filepath);
		
		workbook.write(fos);
		
		fos.close();
		
		
		
		System.out.println("Written successfully in the blank workbook ");

	 }	
		
		
		
		
		
		
         
		
		
		
		
		

	}


