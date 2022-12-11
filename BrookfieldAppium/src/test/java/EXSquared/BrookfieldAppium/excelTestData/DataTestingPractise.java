package EXSquared.BrookfieldAppium.excelTestData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataTestingPractise {

	public static void main(String args[]) throws IOException {
		int k=0;
		int column = 0;
	    int j=0;
	FileInputStream fls = new FileInputStream("C://Users//jschawla//Downloads//Testdata.xlsx");
	System.out.println("1 : " + fls.toString());

	//This accepts file input stream argument
	XSSFWorkbook workbook = new XSSFWorkbook(fls);
	
	int sheets = workbook.getNumberOfSheets();
	System.out.println("2 : " + sheets);
	
	
	for(int i=0;i<sheets;i++) {
		if(workbook.getSheetName(i).equalsIgnoreCase("testdata1")) {
		XSSFSheet sheet = workbook.getSheetAt(i);
		System.out.println("3 : " + i);
		System.out.println("4 : " + sheet.getSheetName());
		Iterator<Row> rows = sheet.iterator();
		
		
		while(rows.hasNext()){
			System.out.println("121212");
			
		
		Row genericRow = rows.next();
	
		Iterator<Cell> ce = genericRow.cellIterator();
		Cell value = ce.next();

		
		
		boolean flag = false;
		while(ce.hasNext()) {
		//	System.out.println("1");
			
			//System.out.println("2");
		//	System.out.println(value.getStringCellValue());
			if(value.getStringCellValue().equalsIgnoreCase("Accept cookies")) {
			//	System.out.println("3");
				
				flag = true;
				//break;
				
				
			}
			if(flag == true) {
				System.out.println("--" + value + "--");
			}
		//	System.out.println("k:");
			k++;
			//System.out.println("==c=="+ column);
			//System.out.println("==k==" + k);
			 value = ce.next();
		}
		
	//	System.out.println("5 : " + column);
		//System.out.println("6 : " + k);
		//System.out.println("7 : " + j);
	//	System.out.println("8 : " + k);
		
		
		if(flag==true) {
			break;
		}
		k=0;
		j++;
		}
		
		System.out.println("142");
		

	
	
	
	
	
	
		}
		}}}
