package firstmaven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePoiDemo {
	
	
	public ArrayList<String> getData(String testcasename) throws IOException
	{
		ArrayList<String> ar=new ArrayList<>();

		// creating object for xssfworkbook class
		FileInputStream fis = new FileInputStream("D:\\Sumit\\ApachePoiDemo.xlsx"); // creating objcet of
																					// FileInputStream by passing path
																					// of the excel file as argument

		XSSFWorkbook workbook = new XSSFWorkbook(fis);// this class is used for .xlsx files...Here creating an object of
														// this class with argument as reference of FileInputStream

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("Sample")) {           //getting access to our sheet 
				XSSFSheet sheet = workbook.getSheetAt(i);

				System.out.println(sheet.getSheetName());
				
				
				Iterator<Row> rows = sheet.iterator();
				
				Row firstrow=rows.next();
				//Row secondrow = rows.next();
				//Row thirdrow=rows.next();
				
				Iterator<Cell> ce = firstrow.cellIterator();
				int k=0;
				int column=0;
				while(ce.hasNext())
				{
					Cell value=ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("Testcase"))
					{
					      column=k;
				     }
				k++;
				
				}
				System.out.println(column);
				
				while(rows.hasNext())
				{
					Row r=rows.next();
					
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename))
					{
						Iterator<Cell>c=r.cellIterator();
						while(c.hasNext())
						{
						Cell cell=c.next();
						if(cell.getCellType()==CellType.STRING)
						{
						   ar.add(cell.getStringCellValue());
						}
						else
						{
							ar.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
						}
					}
				}

			}

		}
		}
		return ar;
	}

	public static void main(String[] args) throws IOException {
		
		

	}
	
	
	
}
