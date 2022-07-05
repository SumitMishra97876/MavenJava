package ractice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class WriteToExcelFromSelenium {
	
	
	
	
	
	public static  void disp(List<WebElement> lists,String sheetname,int rowcnt,int colcnt) throws IOException
	{
     ArrayList<String> values=new ArrayList<String>();
		
		for(int i=0;i<lists.size();i++)
		{
			String text=lists.get(i).getText();
			
		
			
			values.add(text);
		}
		//Object[] data=values.toArray();
		
		System.out.println(values.size());
		
        XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet(sheetname);
		
		ArrayList<Object[]> choices=new ArrayList<Object[]>();
		
		for(int i=0;i<values.size();i++)
		{
		
		choices.add(new Object[] {values.get(i)});
//		choices.add(new Object[] {values.get(1)});
//		choices.add(new Object[] {values.get(2)});
//		choices.add(new Object[] {values.get(3)});
//		choices.add(new Object[] {values.get(4)});
//		choices.add(new Object[] {values.get(5)});
		}
		
		int rowcount=rowcnt;
		
		for(Object val[]:choices)
		{
			XSSFRow row=sheet.createRow(rowcount++);
		
		int colcount=colcnt;
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
       String filepath="D:\\Sumit\\ValuesTimeDate.com.xlsx";
		
		FileOutputStream fos=new FileOutputStream(filepath);
		
		workbook.write(fos);
		
		fos.close();
		
		
		
		System.out.println("Written successfully in the blank workbook ");

	 }	
		
	}



