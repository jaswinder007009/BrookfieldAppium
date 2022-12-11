
package EXSquared.BrookfieldAppium.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataDriven{
	
	public ArrayList<String> getData(String testcaseName) throws IOException{
        ArrayList<String> a = new ArrayList<String>();
		FileInputStream fls = new FileInputStream("C://Users//jschawla//Downloads//Testdata.xlsx");
		System.out.println("1 : " + fls.toString());

		// This accepts file input stream argument 
		XSSFWorkbook workbook = new XSSFWorkbook(fls);

		int sheets = workbook.getNumberOfSheets();
		System.out.println("2 : " + sheets);

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				System.out.println("3 : " + i);
				System.out.println("4 : " + sheet.getSheetName());
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();
				int k = 0;
				int column = 0;
				boolean flag = false;
				while (ce.hasNext()) {
					Cell value = ce.next();
					System.out.println("__**__");
					if (value.getStringCellValue().equalsIgnoreCase("Testcases of sheet 1")) {
						System.out.println("Value is : " + value);
						column = k;
						flag = true;
						break;
					}
					k++;
				}
				
			
				System.out.println("5 : " + column);

				while (rows.hasNext()) {

					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c= cv.next();
							if(c.getCellTypeEnum()==CellType.STRING)
							{

							a.add(c.getStringCellValue());

							}
							else{

							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
							}
					}

				}
			}
		}
		return a;
	}

	public static void main(String args[]) throws IOException {



	}

}