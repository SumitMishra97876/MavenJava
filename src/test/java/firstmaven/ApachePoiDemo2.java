package firstmaven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePoiDemo2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String filepath = "D:\\Sumit\\Countries.xlsx";

		FileInputStream fis = new FileInputStream(filepath);

		XSSFWorkbook book = new XSSFWorkbook(fis);

		int sheets = book.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (book.getSheetName(i).equals("countriesList")) {
				XSSFSheet countriesSheet = book.getSheetAt(i);
				System.out.println(countriesSheet.getSheetName());

				Iterator<Row> rows = countriesSheet.iterator();

				Row row = rows.next();

				Iterator<Cell> cell = row.cellIterator();
				int k = 0;
				int column = 0;
				while (cell.hasNext()) {
					Cell data = cell.next();
					if (data.getStringCellValue().equalsIgnoreCase("CountryName")) {
						column = k;

					}
					k++;

				}
				System.out.println(column);

				while (rows.hasNext()) {
					Row row1 = rows.next();

					if (row1.getCell(column).getStringCellValue().equalsIgnoreCase("New Zealand")) {
						Iterator<Cell> cols = row1.cellIterator();

						while (cols.hasNext()) {
							Cell data = cols.next();

							switch (data.getCellType()) {
							case STRING:
								System.out.print(data.getStringCellValue());
								break;
							case NUMERIC:
								System.out.print(data.getNumericCellValue());
								break;
							case BOOLEAN:
								System.out.print(data.getBooleanCellValue());
								break;
							}
							System.out.print("   |   ");

						}
						System.out.println();
					}
				}

			}
		}

	}

}
