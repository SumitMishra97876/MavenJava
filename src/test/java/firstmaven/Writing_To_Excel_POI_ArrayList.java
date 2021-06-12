package firstmaven;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writing_To_Excel_POI_ArrayList {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("Emp Info");
		
		
		//Creating an ArraYlist which contains our data which we need to write in our blank workbook
		
		ArrayList<Object[]>empdata=new ArrayList<Object[]>();
		
		//Add data in Arraylist
		
		empdata.add(new Object[] {"EmpId","Name","Salary"});
		empdata.add(new Object[] {101,"Shane",15000});
		empdata.add(new Object[] {102,"Ryan",25000});
		empdata.add(new Object[] {103,"Kyle",17000});
		empdata.add(new Object[] {104,"Tim",32000});
		empdata.add(new Object[] {105,"Trent",55000});
		empdata.add(new Object[] {106,"Drew",23000});
		empdata.add(new Object[] {107,"Ben",25000});
		empdata.add(new Object[] {108,"Duke",40000});
		empdata.add(new Object[] {109,"Lance",95000});
		empdata.add(new Object[] {110,"Craig",78000});
		
		
		
		
		
		
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
		String filepath="D:\\Sumit\\Employee1.xlsx";
		
		FileOutputStream fos=new FileOutputStream(filepath);
		
		workbook.write(fos);
		
		fos.close();
		
		
		
		System.out.println("Written successfully in the blank workbook ");

	 }


}
