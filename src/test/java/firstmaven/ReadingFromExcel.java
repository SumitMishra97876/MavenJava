package firstmaven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingFromExcel {

	public static void main(String[] args) throws IOException {
		
		
		String filePath="D:\\Sumit\\ProgramLang.xlsx";
		
		FileInputStream file=new FileInputStream(filePath);
		
		XSSFWorkbook book =new XSSFWorkbook(file);
		
		XSSFSheet sheet=book.getSheet("Lang");
		
		int rows=sheet.getLastRowNum();
		
		int cols=sheet.getRow(0).getLastCellNum();
		
		System.out.println(rows);
		System.out.println(cols);
		
		//getting value from specific row and specific cell
		
		
		System.out.println(sheet.getRow(1).getCell(3).toString());
		
		
		for(int r=0;r<=rows;r++)
		{
			XSSFRow currRow=sheet.getRow(r);
			
			for(int c=0;c<cols;c++)
			{
				XSSFCell cell=currRow.getCell(c);
				System.out.print(cell.toString() + "            ");
			}
			System.out.println();
		}
		

	}

}
