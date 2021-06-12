package firstmaven;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writing_To_Excel_POI {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("Emp Info");
		
		
		Object empdata[][]= { {"EmpId","Name","Job"},
				              { 101,"Sumit","Tester"},
				              { 102,"Tinku","Engineer"},
				              {103,"Rahul","CA"}
				
		                    };
		//Using two normal for loop
		/*int rows=empdata.length;
		int cols=empdata[0].length;
		
		
		for(int r=0;r<rows;r++)
		{
			XSSFRow row=sheet.createRow(r);
			
			for(int c=0;c<cols;c++)
			{
				XSSFCell cell=row.createCell(c);
				
				Object value=empdata[r][c];
				
				if(value instanceof String)
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);
				
			}
			
		}*/
		
		
		
		//USing for each loop
		
		
		//creating a variable rowcount to increase the value of rows as in for each loop rows cant be increased automatically
		
		
		int rowcount=0;
		
		for(Object emp[]:empdata)
		{
			//create a row
			
			XSSFRow row=sheet.createRow(rowcount++);
					
			int colcount=0;//similalry a variable colcount to increase column nums
			
			for(Object value:emp)
			{
				//create cells
				
				XSSFCell cell=row.createCell(colcount++);
				//Before setting the value in each cell we check the data type of the values

						if(value instanceof String)
							cell.setCellValue((String)value);
						if(value instanceof Integer)
							cell.setCellValue((Integer)value);
						if(value instanceof Boolean)
							cell.setCellValue((Boolean)value);		
						
			}
		}
		String filepath="D:\\Sumit\\Employee.xlsx";
		
		FileOutputStream fos=new FileOutputStream(filepath);
		
		workbook.write(fos);
		
		fos.close();
		
		
		
		System.out.println("Written successfully in the blank workbook ");

	 }


}
