package EXSquared.BrookfieldAppium.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvide {

	static DataFormatter formatter = new DataFormatter();

//Data provider in object form
//@DataProvider(name = "driveTest1")
//public Object[][] getData1()
//{
//	//Object is super set of all data types 
//	Object [][] data ={{"hello", "text", 1},{"bye","message",143},{"solo","call",4434}};
//	
// 
//	return data;
//}

	@DataProvider(name = "driveTest")
	public static Object[][] getData() throws IOException {
		FileInputStream fiss = new FileInputStream("C://Users//jschawla//Downloads//Testdata.xlsx");
		System.out.println("1 : " + fiss.toString());
		XSSFWorkbook wb = new XSSFWorkbook(fiss);
		XSSFSheet sheet = wb.getSheetAt(1);
		System.out.println("Sheet name is : " + sheet.getSheetName());
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		XSSFRow row = sheet.getRow(1);
		int columnCount = row.getLastCellNum();
		System.out.println("Cell count" + columnCount);
		// return data;
		Object data[][] = new Object[rowCount - 1][columnCount];

		for (int i = 0; i < rowCount - 1; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
				System.out.println(data[i][j]);
			}
		}
		return data;
	}

}